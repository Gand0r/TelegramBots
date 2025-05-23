package org.telegram.telegrambots.meta.api.objects.commands.scope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;
import lombok.extern.jackson.Jacksonized;
import org.telegram.telegrambots.meta.exceptions.TelegramApiValidationException;
import org.telegram.telegrambots.meta.util.Validations;

/**
 * @author Ruben Bermudez
 * @version 5.3
 *
 * Represents the scope of bot commands, covering a specific member of a group or supergroup chat.
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SuperBuilder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class BotCommandScopeChatMember implements BotCommandScope {
    private static final String TYPE_FIELD = "type";
    private static final String CHATID_FIELD = "chat_id";
    private static final String USERID_FIELD = "user_id";

    /**
     * Scope type, must be chat
     */
    @JsonProperty(TYPE_FIELD)
    private final String type = "chat_member";
    /**
     * Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     */
    @JsonProperty(CHATID_FIELD)
    @NonNull
    private String chatId;
    /**
     * Unique identifier of the target user
     */
    @JsonProperty(USERID_FIELD)
    @NonNull
    private Long userId;

    @Tolerate
    public void setChatId(@NonNull Long chatId) {
        this.chatId = chatId.toString();
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        Validations.requiredChatId(chatId, this);
        Validations.requiredUserId(userId, this);
    }

    public abstract static class BotCommandScopeChatMemberBuilder<C extends BotCommandScopeChatMember, B extends BotCommandScopeChatMemberBuilder<C, B>> {
        @Tolerate
        public BotCommandScopeChatMemberBuilder<C, B> chatId(@NonNull Long chatId) {
            this.chatId = chatId.toString();
            return this;
        }
    }
}
