package org.telegram.telegrambots.meta.api.objects.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.telegram.telegrambots.meta.api.interfaces.BotApiObject;
import org.telegram.telegrambots.meta.api.objects.User;

/**
 * @author Ruben Bermudez
 * @version 7.2
 *
 * Describes the connection of the bot with a business account.
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessConnection implements BotApiObject {
    private static final String ID_FIELD = "id";
    private static final String USER_FIELD = "user";
    private static final String USER_CHAT_ID_FIELD = "user_chat_id";
    private static final String DATE_FIELD = "date";
    private static final String IS_ENABLED_FIELD = "is_enabled";
    private static final String RIGHTS_FIELD = "rights";

    /**
     * Unique identifier of the business connection
     */
    @JsonProperty(ID_FIELD)
    @NonNull
    private String id;
    /**
     * Business account user that created the business connection
     */
    @JsonProperty(USER_FIELD)
    @NonNull
    private User user;
    /**
     * Identifier of a private chat with the user who created the business connection.
     * This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it.
     * But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier.
     */
    @JsonProperty(USER_CHAT_ID_FIELD)
    @NonNull
    private Long userChatId;
    /**
     * Date the connection was established in Unix time
     */
    @JsonProperty(DATE_FIELD)
    @NonNull
    private Integer date;
    /**
     * True, if the connection is active
     */
    @JsonProperty(IS_ENABLED_FIELD)
    @NonNull
    private Boolean isEnabled;
    /**
     * Optional.
     * Rights of the business bot
     */
    @JsonProperty(RIGHTS_FIELD)
    private BusinessBotRights rights;
}
