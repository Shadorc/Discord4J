package discord4j.core.object;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;

import java.util.Objects;
import java.util.Optional;

/**
 * @see <a href="https://discord.com/developers/docs/topics/permissions#role-object-role-tags-structure">
 * Role Tags Object</a>
 */
public class RoleTags implements DiscordObject {

    /**
     * The gateway associated to this object.
     */
    private final GatewayDiscordClient gateway;

    /**
     * The raw data as represented by Discord.
     */
    private final RoleTagsData data;

    public RoleTags(final GatewayDiscordClient gateway, final RoleTagsData data) {
        this.gateway = Objects.requireNonNull(gateway);
        this.data = Objects.requireNonNull(data);
    }

    /**
     * Gets the id of the bot this role belongs to, if present.
     *
     * @return The id of the bot this role belongs to, if present.
     */
    public Optional<Snowflake> getBotId() {
        return data.botId().toOptional();
    }

    /**
     * Gets the id of the integration this role belongs to, if present.
     *
     * @return The id of the integration this role belongs to, if present.
     */
    public Optional<Snowflake> getIntegrationId() {
        return data.integrationId().toOptional();
    }

    /**
     * Gets whether this is the guild's premium subscriber role.
     *
     * @return Whether this is the guild's premium subscriber role.
     */
    public boolean isPremiumSubscriberRole() {
        return !data.premiumSubscriber().isAbsent();
    }

    @Override
    public GatewayDiscordClient getClient() {
        return gateway;
    }

    @Override
    public String toString() {
        return "RoleTags{" +
            "data=" + data +
            '}';
    }
}
