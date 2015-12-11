.class public Lco/vine/android/provider/VineProvider;
.super Landroid/content/ContentProvider;
.source "VineProvider.java"


# static fields
.field private static final ACTIVITY:I = 0x21

.field private static final ACTIVITY_WITH_FOLLOW_REQUESTS:I = 0x22

.field private static final ACTIVITY_WITH_FOLLOW_REQUESTS_ALL:I = 0x23

.field private static final CHANNELS:I = 0x8

.field private static final COMMENTS:I = 0x4

.field private static final CONVERSATION:I = 0x76

.field private static final CONVERSATION_MESSAGE_USER:I = 0x71

.field private static final CONVERSATION_RECIPIENTS:I = 0x72

.field private static final CONVERSATION_RECIPIENTS_USERS_VIEW:I = 0x78

.field private static final CONVERSATION_SINGLE:I = 0x77

.field private static final EDITIONS:I = 0x191

.field private static final FILTER_VINE_FRIENDS:I = 0x75

.field private static final HIDE_PROFILE_REPOSTS:I = 0x74

.field private static final INBOX:I = 0x73

.field private static final LIKES:I = 0x5

.field private static final LOGGABLE:Z

.field private static final MESSAGES:I = 0x6f

.field private static final MESSAGES_SINGLE:I = 0x70

.field private static final NOTIFICATIONS:I = 0x6d

.field private static final POSTS:I = 0x6

.field private static final POST_GROUPS_VIEW_ALL_TIMELINE:I = 0x17

.field private static final POST_GROUPS_VIEW_ALL_TIMELINE_ON_THE_RISE:I = 0x1a

.field private static final POST_GROUPS_VIEW_ALL_TIMELINE_POPULAR_NOW:I = 0x1b

.field private static final POST_GROUPS_VIEW_ALL_TIMELINE_SINGLE:I = 0x1d

.field private static final POST_GROUPS_VIEW_ALL_TIMELINE_TAG:I = 0x1c

.field private static final POST_GROUPS_VIEW_ALL_TIMELINE_USER:I = 0x18

.field private static final POST_GROUPS_VIEW_ALL_TIMELINE_USER_LIKES:I = 0x19

.field private static final POST_GROUPS_VIEW_ARBITRARY_TIMELINE:I = 0x20

.field private static final POST_GROUPS_VIEW_TIMELINE:I = 0x14

.field private static final POST_GROUPS_VIEW_TIMELINE_CHANNEL_POPULAR:I = 0x1e

.field private static final POST_GROUPS_VIEW_TIMELINE_CHANNEL_RECENT:I = 0x1f

.field private static final POST_GROUPS_VIEW_TIMELINE_USER:I = 0x15

.field private static final POST_GROUPS_VIEW_TIMELINE_USER_LIKES:I = 0x16

.field private static final PUT_RECENT_TAG:I = 0x12d

.field private static final RECENT_TAG:I = 0x6e

.field private static final SETTINGS:I = 0x3

.field private static final TAG:Ljava/lang/String; = "VineProvider"

.field private static final TAG_SEARCH_RESULTS:I = 0x7

.field private static final UPDATE_RECENT_TAG:I = 0x1f5

.field private static final USER:I = 0x1

.field private static final USER_GROUPS_VIEW_ALL_FOLLOW:I = 0x66

.field private static final USER_GROUPS_VIEW_FIND_FRIENDS_ADDRESS:I = 0x68

.field private static final USER_GROUPS_VIEW_FIND_FRIENDS_TWITTER:I = 0x69

.field private static final USER_GROUPS_VIEW_FOLLOWERS:I = 0x65

.field private static final USER_GROUPS_VIEW_FOLLOWING:I = 0x64

.field private static final USER_GROUPS_VIEW_FRIENDS:I = 0x67

.field private static final USER_GROUPS_VIEW_LIKERS:I = 0x6a

.field private static final USER_GROUPS_VIEW_REVINERS:I = 0x6c

.field private static final USER_GROUPS_VIEW_USER_SEARCH_RESULTS:I = 0x6b

.field private static final USER_ID:I = 0x2

.field private static final sUriMatcher:Landroid/content/UriMatcher;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x3

    const/4 v1, 0x1

    .line 38
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "VineProvider"

    invoke-static {v0, v4}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    move v0, v1

    :goto_0
    sput-boolean v0, Lco/vine/android/provider/VineProvider;->LOGGABLE:Z

    .line 97
    new-instance v0, Landroid/content/UriMatcher;

    const/4 v2, -0x1

    invoke-direct {v0, v2}, Landroid/content/UriMatcher;-><init>(I)V

    sput-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    .line 100
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v2, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v3, "users"

    invoke-virtual {v0, v2, v3, v1}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 101
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "users/id/#"

    const/4 v3, 0x2

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 102
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "settings"

    invoke-virtual {v0, v1, v2, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 104
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "comments"

    const/4 v3, 0x4

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 105
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "likes"

    const/4 v3, 0x5

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 107
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "posts"

    const/4 v3, 0x6

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 109
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "user_groups_view/following/#"

    const/16 v3, 0x64

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 111
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "user_groups_view/followers/#"

    const/16 v3, 0x65

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 113
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "user_groups_view/all_follow/#"

    const/16 v3, 0x66

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 115
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "user_groups_view/friends/#"

    const/16 v3, 0x67

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 117
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "user_groups_view/find_friends_twitter/#"

    const/16 v3, 0x69

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 119
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "user_groups_view/find_friends_address/#"

    const/16 v3, 0x68

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 121
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "user_groups_view/likers/#"

    const/16 v3, 0x6a

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 123
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "user_groups_view/reviners/#"

    const/16 v3, 0x6c

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 125
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "user_groups_view/user_search_results"

    const/16 v3, 0x6b

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 128
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "post_groups_view/timeline/#"

    const/16 v3, 0x14

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 130
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "post_groups_view/user_profile/#"

    const/16 v3, 0x15

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 132
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "post_groups_view/user_likes/#"

    const/16 v3, 0x16

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 135
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "tag_search_results"

    const/4 v3, 0x7

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 136
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "tag_recently_used"

    const/16 v3, 0x6e

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 137
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "users/hide_profile_reposts/#"

    const/16 v3, 0x74

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 140
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "channels"

    const/16 v3, 0x8

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 142
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "post_comments_likes_view/all_timeline/#"

    const/16 v3, 0x17

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 144
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "post_comments_likes_view/all_timeline_user/#"

    const/16 v3, 0x18

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 146
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "post_comments_likes_view/all_timeline_user_likes/#"

    const/16 v3, 0x19

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 148
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "post_comments_likes_view/all_timeline_on_the_rise/#"

    const/16 v3, 0x1a

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 150
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "post_comments_likes_view/all_timeline_popular/#"

    const/16 v3, 0x1b

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 152
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "post_comments_likes_view/all_timeline_tag/#"

    const/16 v3, 0x1c

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 154
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "post_comments_likes_view/post/#"

    const/16 v3, 0x1d

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 156
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "post_comments_likes_view/timeline_channel_popular/#"

    const/16 v3, 0x1e

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 158
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "post_comments_likes_view/timeline_channel_recent/#"

    const/16 v3, 0x1f

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 160
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "post_comments_likes_view/timelines/#"

    const/16 v3, 0x20

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 165
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "conversations"

    const/16 v3, 0x76

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 166
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "conversations/conversation"

    const/16 v3, 0x77

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 168
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "messages"

    const/16 v3, 0x6f

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 169
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "messages/message"

    const/16 v3, 0x70

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 170
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "message_users_view/conversation"

    const/16 v3, 0x71

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 171
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "conversation_recipients/conversation"

    const/16 v3, 0x72

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 172
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "conversation_recipients_users_view/conversation"

    const/16 v3, 0x78

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 173
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "inbox_view"

    const/16 v3, 0x73

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 174
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "user_groups_view/friends/filter/#"

    const/16 v3, 0x75

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 178
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "tag_recently_used/put_tag"

    const/16 v3, 0x12d

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 179
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "tag_recently_used/update_tag"

    const/16 v3, 0x1f5

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 180
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/Vine;->AUTHORITY:Ljava/lang/String;

    const-string v2, "editions"

    const/16 v3, 0x191

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 181
    return-void

    .line 38
    :cond_1
    const/4 v0, 0x0

    goto/16 :goto_0
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    return-void
.end method


# virtual methods
.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "s"    # Ljava/lang/String;
    .param p3, "strings"    # [Ljava/lang/String;

    .prologue
    .line 842
    const/4 v0, 0x0

    return v0
.end method

.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 3
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 787
    sget-object v0, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 802
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown URL "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 789
    :sswitch_0
    const-string v0, "vnd.android.cursor.dir/vnd.vine.android.users"

    .line 799
    :goto_0
    return-object v0

    .line 792
    :sswitch_1
    const-string v0, "vnd.android.cursor.item/vnd.vine.android.users"

    goto :goto_0

    .line 795
    :sswitch_2
    const-string v0, "vnd.android.cursor.item/vnd.vine.android.settings"

    goto :goto_0

    .line 799
    :sswitch_3
    const-string v0, "vnd.android.cursor.dir/vnd.vine.android.users.groups"

    goto :goto_0

    .line 787
    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0x2 -> :sswitch_1
        0x3 -> :sswitch_2
        0x64 -> :sswitch_3
        0x65 -> :sswitch_3
    .end sparse-switch
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 9
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    const/4 v5, 0x0

    .line 809
    invoke-virtual {p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lco/vine/android/provider/VineDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineDatabaseHelper;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 812
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    sget-boolean v6, Lco/vine/android/provider/VineProvider;->LOGGABLE:Z

    if-eqz v6, :cond_0

    .line 813
    const-string v6, "VineProvider"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "INSERT: uri "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " -> "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sget-object v8, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v8, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 816
    :cond_0
    const-wide/16 v3, -0x1

    .line 818
    .local v3, "rowId":J
    const-string v1, ""

    .line 819
    .local v1, "id":Ljava/lang/String;
    sget-object v6, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v6, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v2

    .line 820
    .local v2, "match":I
    packed-switch v2, :pswitch_data_0

    .line 834
    :cond_1
    :goto_0
    const-wide/16 v6, 0x0

    cmp-long v6, v3, v6

    if-ltz v6, :cond_2

    .line 835
    invoke-virtual {p1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v5

    invoke-virtual {v5, v1}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v5

    invoke-virtual {v5}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v5

    .line 837
    :cond_2
    return-object v5

    .line 822
    :pswitch_0
    const-string v6, "tag_id"

    invoke-virtual {p2, v6}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 823
    const-string v6, "tag_recently_used"

    invoke-virtual {v0, v6, v5, p2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v3

    .line 824
    sget-boolean v6, Lco/vine/android/provider/VineProvider;->LOGGABLE:Z

    if-eqz v6, :cond_1

    .line 825
    const-string v6, "VineProvider"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Tag inserted to recently-used with rowId="

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 820
    :pswitch_data_0
    .packed-switch 0x12d
        :pswitch_0
    .end packed-switch
.end method

.method public onCreate()Z
    .locals 1

    .prologue
    .line 185
    const/4 v0, 0x1

    return v0
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 28
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "projection"    # [Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selArgs"    # [Ljava/lang/String;
    .param p5, "sortOrder"    # Ljava/lang/String;

    .prologue
    .line 192
    const-string v3, "limit"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 193
    .local v9, "limit":Ljava/lang/String;
    const/16 v20, 0x0

    .line 194
    .local v20, "orderBy":Ljava/lang/String;
    const/16 v16, 0x0

    .line 198
    .local v16, "groupBy":Ljava/lang/String;
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/provider/VineDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineDatabaseHelper;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 206
    .local v2, "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_0
    new-instance v1, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v1}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 207
    .local v1, "qb":Landroid/database/sqlite/SQLiteQueryBuilder;
    sget-boolean v3, Lco/vine/android/provider/VineProvider;->LOGGABLE:Z

    if-eqz v3, :cond_0

    .line 208
    const-string v3, "VineProvider"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "QUERY: uri "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, p1

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " -> "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    move-object/from16 v0, p1

    invoke-virtual {v5, v0}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 211
    :cond_0
    sget-object v3, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    move-object/from16 v0, p1

    invoke-virtual {v3, v0}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v18

    .line 213
    .local v18, "match":I
    sparse-switch v18, :sswitch_data_0

    :cond_1
    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .local v6, "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 769
    .end local v20    # "orderBy":Ljava/lang/String;
    .local v8, "orderBy":Ljava/lang/String;
    :goto_1
    invoke-static/range {p5 .. p5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 770
    move-object/from16 v8, p5

    .line 773
    :cond_2
    const/4 v7, 0x0

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    :try_start_1
    invoke-virtual/range {v1 .. v9}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 776
    .local v10, "c":Landroid/database/Cursor;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-interface {v10, v3, v0}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-object v14, v10

    .line 777
    .end local v10    # "c":Landroid/database/Cursor;
    :goto_2
    return-object v14

    .line 200
    .end local v1    # "qb":Landroid/database/sqlite/SQLiteQueryBuilder;
    .end local v2    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v18    # "match":I
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :catch_0
    move-exception v15

    .line 201
    .local v15, "e":Landroid/database/sqlite/SQLiteException;
    const-string v3, "Failed to get a readable database on query."

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v15, v3, v4}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 202
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/provider/VineDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineDatabaseHelper;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .restart local v2    # "db":Landroid/database/sqlite/SQLiteDatabase;
    goto :goto_0

    .line 215
    .end local v15    # "e":Landroid/database/sqlite/SQLiteException;
    .restart local v1    # "qb":Landroid/database/sqlite/SQLiteQueryBuilder;
    .restart local v18    # "match":I
    :sswitch_0
    const-string v3, "users"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 216
    const-string v8, "username ASC"

    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    move-object/from16 v6, v16

    .line 217
    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    goto :goto_1

    .line 220
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_1
    const-string v3, "users"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 221
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "user_id="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 222
    const-string v8, "username ASC"

    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    move-object/from16 v6, v16

    .line 223
    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    goto :goto_1

    .line 226
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_2
    const-string v3, "settings"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 227
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto :goto_1

    .line 230
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_3
    const-string v3, "posts"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 231
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto :goto_1

    .line 234
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_4
    const-string v3, "editions"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 235
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 238
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_5
    const-string v3, "likes"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 239
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 242
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_6
    const-string v3, "comments"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 243
    const-string v8, "comment_id ASC"

    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    move-object/from16 v6, v16

    .line 244
    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 247
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_7
    const-string v3, "user_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 248
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "tag="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " AND "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "type"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x3d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 252
    const-string v6, "user_id"

    .line 253
    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    const-string v8, "order_id DESC"

    .line 254
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 257
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_8
    const-string v3, "user_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 258
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "tag="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " AND "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "type"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x3d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    const/4 v4, 0x2

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 262
    const-string v6, "user_id"

    .line 263
    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    const-string v8, "order_id DESC"

    .line 264
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 267
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_9
    const-string v3, "user_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 268
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "tag="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " AND ("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "type"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x3d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    const/4 v4, 0x2

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " OR "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "type"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x3d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 274
    const-string v6, "user_id"

    .line 275
    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    const-string v8, "_id ASC"

    .line 276
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 279
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_a
    const-string v3, "user_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 280
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "tag="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " AND "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "type"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x3d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0xa

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 284
    const-string v6, "user_id"

    .line 285
    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    const-string v8, "_id ASC"

    .line 286
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 289
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_b
    const-string v3, "user_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 290
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "tag="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " AND "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "type"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x3d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    const/4 v4, 0x6

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 294
    const-string v6, "user_id"

    .line 295
    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    const-string v8, "_id ASC"

    .line 296
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 299
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_c
    const-string v3, "user_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 300
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "tag="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " AND "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "type"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x3d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    const/4 v4, 0x7

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 304
    const-string v6, "user_id"

    .line 305
    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    const-string v8, "_id ASC"

    .line 306
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 309
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_d
    const-string v3, "user_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 310
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "tag="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " AND "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "type"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x3d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    const/4 v4, 0x5

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 314
    const-string v6, "user_id"

    .line 315
    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    const-string v8, "order_id DESC"

    .line 316
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 319
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_e
    const-string v3, "user_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 320
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "tag="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " AND "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "type"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x3d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x9

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 324
    const-string v6, "user_id"

    .line 325
    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    const-string v8, "order_id DESC"

    .line 326
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 329
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_f
    const-string v3, "user_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 330
    const-string v3, "type=8"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 331
    const-string v6, "user_id"

    .line 332
    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    const-string v8, "_id ASC"

    .line 333
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 336
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_10
    const-string v3, "post_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 337
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "tag="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " AND "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "post_type"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x3d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 341
    const-string v8, "sort_id DESC"

    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    move-object/from16 v6, v16

    .line 342
    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 345
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_11
    const-string v3, "post_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 346
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "tag="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " AND "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "post_type"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x3d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    const/4 v4, 0x2

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 350
    const-string v8, "sort_id DESC"

    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    move-object/from16 v6, v16

    .line 351
    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 354
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_12
    const-string v3, "post_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 355
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "tag="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " AND "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "post_type"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x3d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    const/4 v4, 0x3

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 359
    const-string v8, "sort_id DESC"

    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    move-object/from16 v6, v16

    .line 360
    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 363
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_13
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/util/BuildUtil;->isOldDeviceOrLowEndDevice(Landroid/content/Context;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 364
    const-string v3, "post_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 365
    new-instance v14, Lco/vine/android/provider/HybridPostCursorExplore;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostGroupsViewQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "tag=? AND post_type = ?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v7, 0x1

    const/16 v27, 0x1

    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id DESC"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v9, :cond_3

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    :goto_3
    invoke-direct {v14, v4, v3}, Lco/vine/android/provider/HybridPostCursorExplore;-><init>(Landroid/database/Cursor;I)V

    .line 375
    .local v14, "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursorExplore;->prepare(Landroid/content/Context;)V

    .line 376
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursorExplore;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 377
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 365
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :cond_3
    const/4 v3, 0x0

    goto :goto_3

    .line 379
    :cond_4
    const-string v3, "post_comments_likes_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 380
    new-instance v14, Lco/vine/android/provider/HybridPostCursor;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostCommentsLikesQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "tag=? AND post_type = ?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v7, 0x1

    const/16 v27, 0x1

    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id DESC, comment_id ASC, like_id"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v9, :cond_5

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    :goto_4
    invoke-direct {v14, v4, v3}, Lco/vine/android/provider/HybridPostCursor;-><init>(Landroid/database/Cursor;I)V

    .line 390
    .local v14, "cursor":Lco/vine/android/provider/HybridPostCursor;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursor;->prepare(Landroid/content/Context;)V

    .line 391
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 392
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 380
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursor;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :cond_5
    const/4 v3, 0x0

    goto :goto_4

    .line 396
    :sswitch_14
    const-string v3, "hide_profile_reposts"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 398
    .local v17, "hideProfileReposts":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v25

    .line 401
    .local v25, "userId":Ljava/lang/String;
    const-string v3, "0"

    move-object/from16 v0, v17

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 402
    const/4 v3, 0x2

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v24

    .line 407
    .local v24, "type":Ljava/lang/String;
    :goto_5
    const-string p3, "tag=? AND post_type=?"

    .line 408
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/util/BuildUtil;->isOldDeviceOrLowEndDevice(Landroid/content/Context;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 409
    const-string v3, "post_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 410
    new-instance v14, Lco/vine/android/provider/HybridPostCursorExplore;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostGroupsViewQuery;->PROJECTION:[Ljava/lang/String;

    const/4 v4, 0x2

    new-array v5, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object v25, v5, v4

    const/4 v4, 0x1

    aput-object v24, v5, v4

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id DESC"

    move-object/from16 v4, p3

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v9, :cond_7

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    :goto_6
    invoke-direct {v14, v4, v3}, Lco/vine/android/provider/HybridPostCursorExplore;-><init>(Landroid/database/Cursor;I)V

    .line 417
    .local v14, "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursorExplore;->prepare(Landroid/content/Context;)V

    .line 418
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursorExplore;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 419
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 404
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    .end local v24    # "type":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :cond_6
    const/16 v3, 0xa

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v24

    .restart local v24    # "type":Ljava/lang/String;
    goto :goto_5

    .line 410
    :cond_7
    const/4 v3, 0x0

    goto :goto_6

    .line 421
    :cond_8
    const-string v3, "post_comments_likes_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 422
    new-instance v14, Lco/vine/android/provider/HybridPostCursor;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostCommentsLikesQuery;->PROJECTION:[Ljava/lang/String;

    const/4 v4, 0x2

    new-array v5, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object v25, v5, v4

    const/4 v4, 0x1

    aput-object v24, v5, v4

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id DESC, comment_id ASC, like_id"

    move-object/from16 v4, p3

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v9, :cond_9

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    :goto_7
    invoke-direct {v14, v4, v3}, Lco/vine/android/provider/HybridPostCursor;-><init>(Landroid/database/Cursor;I)V

    .line 429
    .local v14, "cursor":Lco/vine/android/provider/HybridPostCursor;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursor;->prepare(Landroid/content/Context;)V

    .line 430
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 431
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 422
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursor;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :cond_9
    const/4 v3, 0x0

    goto :goto_7

    .line 435
    .end local v17    # "hideProfileReposts":Ljava/lang/String;
    .end local v24    # "type":Ljava/lang/String;
    .end local v25    # "userId":Ljava/lang/String;
    :sswitch_15
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/util/BuildUtil;->isOldDeviceOrLowEndDevice(Landroid/content/Context;)Z

    move-result v3

    if-eqz v3, :cond_b

    .line 436
    const-string v3, "post_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 437
    new-instance v14, Lco/vine/android/provider/HybridPostCursorExplore;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostGroupsViewQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "tag=? AND post_type = ?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v7, 0x1

    const/16 v27, 0x3

    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id DESC"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v9, :cond_a

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    :goto_8
    invoke-direct {v14, v4, v3}, Lco/vine/android/provider/HybridPostCursorExplore;-><init>(Landroid/database/Cursor;I)V

    .line 447
    .local v14, "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursorExplore;->prepare(Landroid/content/Context;)V

    .line 448
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursorExplore;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 449
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 437
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :cond_a
    const/4 v3, 0x0

    goto :goto_8

    .line 451
    :cond_b
    const-string v3, "post_comments_likes_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 452
    new-instance v14, Lco/vine/android/provider/HybridPostCursor;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostCommentsLikesQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "tag=? AND post_type = ?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v7, 0x1

    const/16 v27, 0x3

    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id DESC, comment_id ASC, like_id"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v9, :cond_c

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    :goto_9
    invoke-direct {v14, v4, v3}, Lco/vine/android/provider/HybridPostCursor;-><init>(Landroid/database/Cursor;I)V

    .line 462
    .local v14, "cursor":Lco/vine/android/provider/HybridPostCursor;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursor;->prepare(Landroid/content/Context;)V

    .line 463
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 464
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 452
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursor;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :cond_c
    const/4 v3, 0x0

    goto :goto_9

    .line 468
    :sswitch_16
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/util/BuildUtil;->isOldDeviceOrLowEndDevice(Landroid/content/Context;)Z

    move-result v3

    if-eqz v3, :cond_e

    .line 469
    const-string v3, "post_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 470
    new-instance v14, Lco/vine/android/provider/HybridPostCursorExplore;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostGroupsViewQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "tag=? AND post_type = ?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v7, 0x1

    const/16 v27, 0x4

    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id DESC"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v9, :cond_d

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    :goto_a
    invoke-direct {v14, v4, v3}, Lco/vine/android/provider/HybridPostCursorExplore;-><init>(Landroid/database/Cursor;I)V

    .line 480
    .local v14, "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursorExplore;->prepare(Landroid/content/Context;)V

    .line 481
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursorExplore;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 482
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 470
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :cond_d
    const/4 v3, 0x0

    goto :goto_a

    .line 484
    :cond_e
    const-string v3, "post_comments_likes_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 485
    new-instance v14, Lco/vine/android/provider/HybridPostCursor;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostCommentsLikesQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "tag=? AND post_type = ?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v7, 0x1

    const/16 v27, 0x4

    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id ASC, post_id DESC, comment_id ASC, like_id"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v9, :cond_f

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    :goto_b
    invoke-direct {v14, v4, v3}, Lco/vine/android/provider/HybridPostCursor;-><init>(Landroid/database/Cursor;I)V

    .line 495
    .local v14, "cursor":Lco/vine/android/provider/HybridPostCursor;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursor;->prepare(Landroid/content/Context;)V

    .line 496
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 497
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 485
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursor;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :cond_f
    const/4 v3, 0x0

    goto :goto_b

    .line 501
    :sswitch_17
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/util/BuildUtil;->isOldDeviceOrLowEndDevice(Landroid/content/Context;)Z

    move-result v3

    if-eqz v3, :cond_11

    .line 502
    const-string v3, "post_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 503
    new-instance v14, Lco/vine/android/provider/HybridPostCursorExplore;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostGroupsViewQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "post_type = ?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    const/16 v27, 0x5

    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id DESC"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v9, :cond_10

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    :goto_c
    invoke-direct {v14, v4, v3}, Lco/vine/android/provider/HybridPostCursorExplore;-><init>(Landroid/database/Cursor;I)V

    .line 511
    .local v14, "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursorExplore;->prepare(Landroid/content/Context;)V

    .line 512
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursorExplore;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 513
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 503
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :cond_10
    const/4 v3, 0x0

    goto :goto_c

    .line 515
    :cond_11
    const-string v3, "post_comments_likes_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 516
    new-instance v14, Lco/vine/android/provider/HybridPostCursor;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostCommentsLikesQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "post_type = ?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    const/16 v27, 0x5

    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id ASC, post_id DESC, comment_id ASC, like_id"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v9, :cond_12

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    :goto_d
    invoke-direct {v14, v4, v3}, Lco/vine/android/provider/HybridPostCursor;-><init>(Landroid/database/Cursor;I)V

    .line 524
    .local v14, "cursor":Lco/vine/android/provider/HybridPostCursor;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursor;->prepare(Landroid/content/Context;)V

    .line 525
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 526
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 516
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursor;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :cond_12
    const/4 v3, 0x0

    goto :goto_d

    .line 530
    :sswitch_18
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/util/BuildUtil;->isOldDeviceOrLowEndDevice(Landroid/content/Context;)Z

    move-result v3

    if-eqz v3, :cond_14

    .line 531
    const-string v3, "post_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 532
    const-string v3, "tag_name"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    .line 533
    .local v23, "tag":Ljava/lang/String;
    new-instance v14, Lco/vine/android/provider/HybridPostCursorExplore;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostGroupsViewQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "tag=? AND post_type = ?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object v23, v5, v7

    const/4 v7, 0x1

    const/16 v27, 0x6

    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id DESC"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v9, :cond_13

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    :goto_e
    invoke-direct {v14, v4, v3}, Lco/vine/android/provider/HybridPostCursorExplore;-><init>(Landroid/database/Cursor;I)V

    .line 543
    .local v14, "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursorExplore;->prepare(Landroid/content/Context;)V

    .line 544
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursorExplore;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 545
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 533
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :cond_13
    const/4 v3, 0x0

    goto :goto_e

    .line 547
    .end local v23    # "tag":Ljava/lang/String;
    :cond_14
    const-string v3, "post_comments_likes_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 548
    const-string v3, "tag_name"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    .line 549
    .restart local v23    # "tag":Ljava/lang/String;
    new-instance v14, Lco/vine/android/provider/HybridPostCursor;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostCommentsLikesQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "tag=? AND post_type = ?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object v23, v5, v7

    const/4 v7, 0x1

    const/16 v27, 0x6

    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id DESC, comment_id ASC, like_id"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v9, :cond_15

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    :goto_f
    invoke-direct {v14, v4, v3}, Lco/vine/android/provider/HybridPostCursor;-><init>(Landroid/database/Cursor;I)V

    .line 559
    .local v14, "cursor":Lco/vine/android/provider/HybridPostCursor;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursor;->prepare(Landroid/content/Context;)V

    .line 560
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 561
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 549
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursor;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :cond_15
    const/4 v3, 0x0

    goto :goto_f

    .line 565
    .end local v23    # "tag":Ljava/lang/String;
    :sswitch_19
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/util/BuildUtil;->isOldDeviceOrLowEndDevice(Landroid/content/Context;)Z

    move-result v3

    if-eqz v3, :cond_16

    .line 566
    const-string v3, "post_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 567
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v21

    .line 568
    .local v21, "postId":Ljava/lang/String;
    new-instance v14, Lco/vine/android/provider/HybridPostCursorExplore;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostGroupsViewQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "post_id=? AND post_type=?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object v21, v5, v7

    const/4 v7, 0x1

    const/16 v27, 0x7

    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id DESC"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v3

    invoke-direct {v14, v3}, Lco/vine/android/provider/HybridPostCursorExplore;-><init>(Landroid/database/Cursor;)V

    .line 576
    .local v14, "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursorExplore;->prepare(Landroid/content/Context;)V

    .line 577
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursorExplore;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 578
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 580
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    .end local v21    # "postId":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :cond_16
    const-string v3, "post_comments_likes_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 581
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v21

    .line 582
    .restart local v21    # "postId":Ljava/lang/String;
    new-instance v14, Lco/vine/android/provider/HybridPostCursor;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostCommentsLikesQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "post_id=? AND post_type=?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object v21, v5, v7

    const/4 v7, 0x1

    const/16 v27, 0x7

    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id DESC, comment_id ASC, like_id"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v3

    invoke-direct {v14, v3}, Lco/vine/android/provider/HybridPostCursor;-><init>(Landroid/database/Cursor;)V

    .line 590
    .local v14, "cursor":Lco/vine/android/provider/HybridPostCursor;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursor;->prepare(Landroid/content/Context;)V

    .line 591
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 592
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 596
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursor;
    .end local v21    # "postId":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_1a
    const-string v3, "tag_search_results"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 597
    const-string v8, "_id ASC"

    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    move-object/from16 v6, v16

    .line 598
    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 601
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_1b
    const-string v3, "channels"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 602
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 605
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_1c
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/util/BuildUtil;->isOldDeviceOrLowEndDevice(Landroid/content/Context;)Z

    move-result v3

    if-eqz v3, :cond_18

    .line 606
    const-string v3, "post_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 607
    const-string v3, "channel_id"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 608
    .local v11, "channelId":Ljava/lang/String;
    new-instance v14, Lco/vine/android/provider/HybridPostCursorExplore;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostGroupsViewQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "post_type = ? AND tag = ?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    const/16 v27, 0x8

    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v7, 0x1

    aput-object v11, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id DESC"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v9, :cond_17

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    :goto_10
    invoke-direct {v14, v4, v3}, Lco/vine/android/provider/HybridPostCursorExplore;-><init>(Landroid/database/Cursor;I)V

    .line 616
    .local v14, "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursorExplore;->prepare(Landroid/content/Context;)V

    .line 617
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursorExplore;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 635
    .end local v11    # "channelId":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    :sswitch_1d
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/util/BuildUtil;->isOldDeviceOrLowEndDevice(Landroid/content/Context;)Z

    move-result v3

    if-eqz v3, :cond_1b

    .line 636
    const-string v3, "post_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 637
    const-string v3, "channel_id"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 638
    .restart local v11    # "channelId":Ljava/lang/String;
    new-instance v14, Lco/vine/android/provider/HybridPostCursorExplore;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostGroupsViewQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "post_type = ? AND tag = ?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    const/16 v27, 0x9

    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v7, 0x1

    aput-object v11, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id DESC"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v9, :cond_1a

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    :goto_11
    invoke-direct {v14, v4, v3}, Lco/vine/android/provider/HybridPostCursorExplore;-><init>(Landroid/database/Cursor;I)V

    .line 646
    .restart local v14    # "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursorExplore;->prepare(Landroid/content/Context;)V

    .line 647
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursorExplore;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 648
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 608
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :cond_17
    const/4 v3, 0x0

    goto :goto_10

    .line 619
    .end local v11    # "channelId":Ljava/lang/String;
    :cond_18
    const-string v3, "post_comments_likes_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 620
    const-string v3, "channel_id"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 621
    .restart local v11    # "channelId":Ljava/lang/String;
    new-instance v14, Lco/vine/android/provider/HybridPostCursor;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostCommentsLikesQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "post_type = ? AND tag = ?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    const/16 v27, 0x8

    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v7, 0x1

    aput-object v11, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id ASC, post_id DESC, comment_id ASC, like_id"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v9, :cond_19

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    :goto_12
    invoke-direct {v14, v4, v3}, Lco/vine/android/provider/HybridPostCursor;-><init>(Landroid/database/Cursor;I)V

    .line 629
    .local v14, "cursor":Lco/vine/android/provider/HybridPostCursor;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursor;->prepare(Landroid/content/Context;)V

    .line 630
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 631
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 621
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursor;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :cond_19
    const/4 v3, 0x0

    goto :goto_12

    .line 638
    :cond_1a
    const/4 v3, 0x0

    goto :goto_11

    .line 650
    .end local v11    # "channelId":Ljava/lang/String;
    :cond_1b
    const-string v3, "post_comments_likes_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 651
    const-string v3, "channel_id"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 652
    .restart local v11    # "channelId":Ljava/lang/String;
    new-instance v14, Lco/vine/android/provider/HybridPostCursor;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostCommentsLikesQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "post_type = ? AND tag = ?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    const/16 v27, 0x9

    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v7, 0x1

    aput-object v11, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id DESC, comment_id ASC, like_id"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v9, :cond_1c

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    :goto_13
    invoke-direct {v14, v4, v3}, Lco/vine/android/provider/HybridPostCursor;-><init>(Landroid/database/Cursor;I)V

    .line 660
    .restart local v14    # "cursor":Lco/vine/android/provider/HybridPostCursor;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursor;->prepare(Landroid/content/Context;)V

    .line 661
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 662
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 652
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursor;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :cond_1c
    const/4 v3, 0x0

    goto :goto_13

    .line 666
    .end local v11    # "channelId":Ljava/lang/String;
    :sswitch_1e
    const-string v3, "tag_name"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    .line 667
    .restart local v23    # "tag":Ljava/lang/String;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/util/BuildUtil;->isOldDeviceOrLowEndDevice(Landroid/content/Context;)Z

    move-result v3

    if-eqz v3, :cond_1e

    .line 668
    const-string v3, "post_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 669
    new-instance v14, Lco/vine/android/provider/HybridPostCursorExplore;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostGroupsViewQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "post_type = ? AND tag = ?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    const/16 v27, 0xb

    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v7, 0x1

    aput-object v23, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id DESC"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v9, :cond_1d

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    :goto_14
    invoke-direct {v14, v4, v3}, Lco/vine/android/provider/HybridPostCursorExplore;-><init>(Landroid/database/Cursor;I)V

    .line 675
    .local v14, "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursorExplore;->prepare(Landroid/content/Context;)V

    .line 676
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursorExplore;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 691
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursorExplore;
    .end local v23    # "tag":Ljava/lang/String;
    :sswitch_1f
    const-string v3, "notifications"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 692
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 669
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    .restart local v23    # "tag":Ljava/lang/String;
    :cond_1d
    const/4 v3, 0x0

    goto :goto_14

    .line 678
    :cond_1e
    const-string v3, "post_comments_likes_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 679
    new-instance v14, Lco/vine/android/provider/HybridPostCursor;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostCommentsLikesQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "post_type = ? AND tag = ?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v7, 0x0

    const/16 v27, 0xb

    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v27

    aput-object v27, v5, v7

    const/4 v7, 0x1

    aput-object v23, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "sort_id ASC, post_id DESC, comment_id ASC, like_id"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v9, :cond_1f

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    :goto_15
    invoke-direct {v14, v4, v3}, Lco/vine/android/provider/HybridPostCursor;-><init>(Landroid/database/Cursor;I)V

    .line 685
    .local v14, "cursor":Lco/vine/android/provider/HybridPostCursor;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v14, v3}, Lco/vine/android/provider/HybridPostCursor;->prepare(Landroid/content/Context;)V

    .line 686
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v14, v3, v0}, Lco/vine/android/provider/HybridPostCursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 687
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 679
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v14    # "cursor":Lco/vine/android/provider/HybridPostCursor;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :cond_1f
    const/4 v3, 0x0

    goto :goto_15

    .line 695
    .end local v23    # "tag":Ljava/lang/String;
    :sswitch_20
    const-string v3, "tag_recently_used"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 696
    const/4 v7, 0x0

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    move-object/from16 v6, v16

    move-object/from16 v8, p5

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v14

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_2

    .line 699
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_21
    const-string v3, "messages"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 700
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 703
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_22
    const-string v3, "message_id"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 704
    .local v19, "messageId":Ljava/lang/String;
    const-string v3, "messages"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 705
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "message_id="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 706
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 709
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v19    # "messageId":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_23
    const-string v3, "conversations"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 710
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 713
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_24
    const-string v3, "conversation_id"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 714
    .local v12, "conversationId":Ljava/lang/String;
    const-string v3, "conversations"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 715
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "conversation_id="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 716
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 719
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v12    # "conversationId":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_25
    const-string v3, "conversation_row_id"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 720
    .local v13, "conversationObjectId":Ljava/lang/String;
    const-string v3, "message_users_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 721
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "conversation_row_id="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 722
    const-string p3, "deleted=0"

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 723
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 726
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v13    # "conversationObjectId":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_26
    const-string v3, "conversation_row_id"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 727
    .restart local v13    # "conversationObjectId":Ljava/lang/String;
    const-string v3, "conversation_recipients"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 728
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "conversation_row_id="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 729
    const-string v6, "user_row_id"

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 730
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 733
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v13    # "conversationObjectId":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_27
    const-string v3, "conversation_row_id"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 734
    .restart local v13    # "conversationObjectId":Ljava/lang/String;
    const-string v3, "conversation_recipients_users_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 735
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "conversation_row_id="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 736
    const-string v6, "user_row_id"

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 737
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 740
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v13    # "conversationObjectId":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_28
    const-string v3, "inbox_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 741
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "is_hidden="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "hidden"

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " AND "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "network_type"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x3d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "network_type"

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 743
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 746
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_29
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v25

    .line 747
    .restart local v25    # "userId":Ljava/lang/String;
    const-string p3, "user_id=?"

    .line 748
    const/4 v3, 0x1

    new-array v0, v3, [Ljava/lang/String;

    move-object/from16 p4, v0

    .end local p4    # "selArgs":[Ljava/lang/String;
    const/4 v3, 0x0

    invoke-static/range {v25 .. v25}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, p4, v3

    .line 749
    .restart local p4    # "selArgs":[Ljava/lang/String;
    const-string v3, "users"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 750
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 753
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v25    # "userId":Ljava/lang/String;
    .restart local v16    # "groupBy":Ljava/lang/String;
    .restart local v20    # "orderBy":Ljava/lang/String;
    :sswitch_2a
    const-string v3, "user_groups_view"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 754
    const-string v3, "filter"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    .line 755
    .local v22, "query":Ljava/lang/String;
    const-string v3, "group_type"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    .line 756
    .restart local v24    # "type":Ljava/lang/String;
    invoke-static/range {v22 .. v22}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 757
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "%"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, v22

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "%"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v26

    .line 758
    .local v26, "wildcardQuery":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "tag="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " AND "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "type"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, v24

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " AND ("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "username"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " LIKE ? OR "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "description"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " LIKE ?)"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p3

    .line 762
    const/4 v3, 0x2

    new-array v0, v3, [Ljava/lang/String;

    move-object/from16 p4, v0

    .end local p4    # "selArgs":[Ljava/lang/String;
    const/4 v3, 0x0

    aput-object v26, p4, v3

    const/4 v3, 0x1

    aput-object v26, p4, v3

    .restart local p4    # "selArgs":[Ljava/lang/String;
    move-object/from16 v6, v16

    .end local v16    # "groupBy":Ljava/lang/String;
    .restart local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v8, v20

    .line 763
    .end local v20    # "orderBy":Ljava/lang/String;
    .restart local v8    # "orderBy":Ljava/lang/String;
    goto/16 :goto_1

    .line 778
    .end local v22    # "query":Ljava/lang/String;
    .end local v24    # "type":Ljava/lang/String;
    .end local v26    # "wildcardQuery":Ljava/lang/String;
    :catch_1
    move-exception v15

    .line 779
    .local v15, "e":Ljava/lang/Exception;
    const-string v3, "Cannot execute {} - {}: {} {} {} {} {}."

    const/4 v4, 0x7

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    const/4 v5, 0x1

    invoke-static/range {v18 .. v18}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v4, v5

    const/4 v5, 0x2

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->toString()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v5

    const/4 v5, 0x3

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->getTables()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v5

    const/4 v5, 0x4

    aput-object p3, v4, v5

    const/4 v5, 0x5

    aput-object v6, v4, v5

    const/4 v5, 0x6

    aput-object v8, v4, v5

    invoke-static {v3, v4}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 781
    new-instance v3, Ljava/lang/RuntimeException;

    invoke-direct {v3, v15}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v3

    .line 213
    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0x2 -> :sswitch_1
        0x3 -> :sswitch_2
        0x4 -> :sswitch_6
        0x5 -> :sswitch_5
        0x6 -> :sswitch_3
        0x7 -> :sswitch_1a
        0x8 -> :sswitch_1b
        0x14 -> :sswitch_10
        0x15 -> :sswitch_11
        0x16 -> :sswitch_12
        0x17 -> :sswitch_13
        0x18 -> :sswitch_14
        0x19 -> :sswitch_15
        0x1a -> :sswitch_16
        0x1b -> :sswitch_17
        0x1c -> :sswitch_18
        0x1d -> :sswitch_19
        0x1e -> :sswitch_1c
        0x1f -> :sswitch_1d
        0x20 -> :sswitch_1e
        0x64 -> :sswitch_7
        0x65 -> :sswitch_8
        0x66 -> :sswitch_9
        0x67 -> :sswitch_a
        0x68 -> :sswitch_c
        0x69 -> :sswitch_b
        0x6a -> :sswitch_d
        0x6b -> :sswitch_f
        0x6c -> :sswitch_e
        0x6d -> :sswitch_1f
        0x6e -> :sswitch_20
        0x6f -> :sswitch_21
        0x70 -> :sswitch_22
        0x71 -> :sswitch_25
        0x72 -> :sswitch_26
        0x73 -> :sswitch_28
        0x74 -> :sswitch_29
        0x75 -> :sswitch_2a
        0x76 -> :sswitch_23
        0x77 -> :sswitch_24
        0x78 -> :sswitch_27
        0x191 -> :sswitch_4
    .end sparse-switch
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 6
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 847
    invoke-virtual {p0}, Lco/vine/android/provider/VineProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/provider/VineDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineDatabaseHelper;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 850
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    sget-boolean v3, Lco/vine/android/provider/VineProvider;->LOGGABLE:Z

    if-eqz v3, :cond_0

    .line 851
    const-string v3, "VineProvider"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "UPDATE: uri "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " -> "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v5, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 854
    :cond_0
    const/4 v2, 0x0

    .line 855
    .local v2, "updated":I
    sget-object v3, Lco/vine/android/provider/VineProvider;->sUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v3, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v1

    .line 856
    .local v1, "match":I
    packed-switch v1, :pswitch_data_0

    .line 866
    :goto_0
    return v2

    .line 858
    :pswitch_0
    const-string v3, "tag_recently_used"

    invoke-virtual {v0, v3, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_0

    .line 856
    nop

    :pswitch_data_0
    .packed-switch 0x1f5
        :pswitch_0
    .end packed-switch
.end method
