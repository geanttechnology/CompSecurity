.class public Lco/vine/android/provider/VineDatabaseHelper;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "VineDatabaseHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;
    }
.end annotation


# static fields
.field private static final CURRENT_ACCOUNT_KEY:Ljava/lang/String; = "current_account"

.field private static final CURRENT_ACCOUNT_NAME:Ljava/lang/String; = "current_name"

.field private static final CURRENT_USER_ID_KEY:Ljava/lang/String; = "current_user_id"

.field public static final DATABASE_VERSION:I = 0x18

.field private static final DB_NAME:Ljava/lang/String; = "vine"

.field private static final LOGGABLE:Z

.field private static final MAX_ACTIVITY_TABLE_SIZE:I = 0x1f4

.field private static final MAX_COMMENTS_TABLE_SIZE:I = 0x1388

.field private static final MAX_LIKES_TABLE_SIZE:I = 0x1388

.field private static final MAX_POST_TABLE_SIZE:I = 0x3e8

.field private static final MAX_USERS_TABLE_SIZE:I = 0x2710

.field public static final SCHEMA_VERSION:I = 0x1

.field private static final SEPARATOR:Ljava/lang/String; = "-"

.field public static final SETTINGS_NAME_SELECTION:Ljava/lang/String; = "name=?"

.field private static final TAG:Ljava/lang/String; = "VineDH"

.field private static final sHelperMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lco/vine/android/provider/VineDatabaseHelper;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mAppContext:Landroid/content/Context;

.field private mContentResolver:Landroid/content/ContentResolver;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 92
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "VineDH"

    const/4 v1, 0x3

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    .line 109
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lco/vine/android/provider/VineDatabaseHelper;->sHelperMap:Ljava/util/HashMap;

    return-void

    .line 92
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 127
    const/4 v0, 0x0

    const/16 v1, 0x18

    invoke-direct {p0, p1, p2, v0, v1}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    .line 128
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    .line 129
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mAppContext:Landroid/content/Context;

    .line 130
    return-void
.end method

.method private dropTables(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 172
    const-string v0, "DROP VIEW IF EXISTS  user_groups_view;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 173
    const-string v0, "DROP VIEW IF EXISTS  post_groups_view;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 174
    const-string v0, "DROP VIEW IF EXISTS  post_comments_likes_view;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 175
    const-string v0, "DROP TABLE IF EXISTS users;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 176
    const-string v0, "DROP TABLE IF EXISTS settings;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 177
    const-string v0, "DROP TABLE IF EXISTS user_groups;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 178
    const-string v0, "DROP TABLE IF EXISTS comments;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 179
    const-string v0, "DROP TABLE IF EXISTS likes;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 180
    const-string v0, "DROP TABLE IF EXISTS posts;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 181
    const-string v0, "DROP TABLE IF EXISTS post_groups;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 182
    const-string v0, "DROP TABLE IF EXISTS page_cursors;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 183
    const-string v0, "DROP TABLE IF EXISTS tag_search_results;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 184
    const-string v0, "DROP TABLE IF EXISTS tag_search_results;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 185
    const-string v0, "DROP TABLE IF EXISTS channels;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 186
    const-string v0, "DROP TABLE IF EXISTS notifications;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 187
    const-string v0, "DROP TABLE IF EXISTS tag_recently_used;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 188
    const-string v0, "DROP TABLE IF EXISTS editions;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 189
    const-string v0, "DROP TABLE IF EXISTS messages;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 190
    const-string v0, "DROP TABLE IF EXISTS conversation_recipients;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 191
    const-string v0, "DROP TABLE IF EXISTS conversations;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 192
    const-string v0, "DROP TABLE IF EXISTS user_sections;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 193
    const-string v0, "DROP VIEW IF EXISTS message_users_view;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 194
    const-string v0, "DROP VIEW IF EXISTS inbox_view;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 195
    const-string v0, "DROP VIEW IF EXISTS conversation_recipients_users_view;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 196
    return-void
.end method

.method private fillChannelValues(Landroid/content/ContentValues;Lco/vine/android/api/VineChannel;)V
    .locals 3
    .param p1, "values"    # Landroid/content/ContentValues;
    .param p2, "channel"    # Lco/vine/android/api/VineChannel;

    .prologue
    .line 3196
    const-string v0, "channel_id"

    iget-wide v1, p2, Lco/vine/android/api/VineChannel;->channelId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3197
    const-string v0, "channel"

    iget-object v1, p2, Lco/vine/android/api/VineChannel;->channel:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3198
    const-string v0, "background_color"

    iget-object v1, p2, Lco/vine/android/api/VineChannel;->backgroundColor:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3199
    const-string v0, "font_color"

    iget-object v1, p2, Lco/vine/android/api/VineChannel;->fontColor:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3200
    const-string v0, "timestamp"

    iget-wide v1, p2, Lco/vine/android/api/VineChannel;->created:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3201
    const-string v0, "icon_full_url"

    iget-object v1, p2, Lco/vine/android/api/VineChannel;->iconFullUrl:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3202
    const-string v0, "retina_icon_full_url"

    iget-object v1, p2, Lco/vine/android/api/VineChannel;->retinaIconFullUrl:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3203
    return-void
.end method

.method private fillCommentValues(Landroid/content/ContentValues;Lco/vine/android/api/VineComment;J)V
    .locals 3
    .param p1, "values"    # Landroid/content/ContentValues;
    .param p2, "comment"    # Lco/vine/android/api/VineComment;
    .param p3, "lastRefresh"    # J

    .prologue
    .line 3179
    const-string v0, "comment_id"

    iget-wide v1, p2, Lco/vine/android/api/VineComment;->commentId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3180
    const-string v0, "user_id"

    iget-wide v1, p2, Lco/vine/android/api/VineComment;->userId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3181
    const-string v0, "post_id"

    iget-wide v1, p2, Lco/vine/android/api/VineComment;->postId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3182
    const-string v0, "avatar_url"

    iget-object v1, p2, Lco/vine/android/api/VineComment;->avatarUrl:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3183
    const-string v0, "comment"

    iget-object v1, p2, Lco/vine/android/api/VineComment;->comment:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3184
    const-string v0, "timestamp"

    iget-wide v1, p2, Lco/vine/android/api/VineComment;->timestamp:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3185
    const-string v0, "location"

    iget-object v1, p2, Lco/vine/android/api/VineComment;->location:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3186
    const-string v0, "username"

    iget-object v1, p2, Lco/vine/android/api/VineComment;->username:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3187
    const-string v0, "verified"

    iget-boolean v1, p2, Lco/vine/android/api/VineComment;->verified:Z

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 3188
    iget-object v0, p2, Lco/vine/android/api/VineComment;->entities:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    .line 3189
    const-string v0, "entities"

    iget-object v1, p2, Lco/vine/android/api/VineComment;->entities:Ljava/util/ArrayList;

    invoke-static {v1}, Lco/vine/android/util/Util;->toByteArray(Ljava/lang/Object;)[B

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;[B)V

    .line 3191
    :cond_0
    const-string v0, "last_refresh"

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3192
    const-string v0, "is_last"

    iget-boolean v1, p2, Lco/vine/android/api/VineComment;->isLast:Z

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 3193
    return-void
.end method

.method private fillConversationValues(Landroid/content/ContentValues;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;JJ)V
    .locals 2
    .param p1, "values"    # Landroid/content/ContentValues;
    .param p2, "conversationId"    # Ljava/lang/Long;
    .param p3, "networkType"    # Ljava/lang/Integer;
    .param p4, "hidden"    # Ljava/lang/Boolean;
    .param p5, "unreadMessageCount"    # J
    .param p7, "lastMessage"    # J

    .prologue
    .line 3129
    if-eqz p2, :cond_0

    .line 3130
    const-string v0, "conversation_id"

    invoke-virtual {p1, v0, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3132
    :cond_0
    if-eqz p3, :cond_1

    .line 3133
    const-string v0, "network_type"

    invoke-virtual {p1, v0, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3135
    :cond_1
    if-eqz p4, :cond_2

    .line 3136
    const-string v1, "is_hidden"

    invoke-virtual {p4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_5

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3138
    :cond_2
    const-wide/16 v0, -0x1

    cmp-long v0, p5, v0

    if-lez v0, :cond_3

    .line 3139
    const-string v0, "unread_message_count"

    invoke-static {p5, p6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3141
    :cond_3
    const-wide/16 v0, 0x0

    cmp-long v0, p7, v0

    if-lez v0, :cond_4

    .line 3142
    const-string v0, "last_message"

    invoke-static {p7, p8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3144
    :cond_4
    return-void

    .line 3136
    :cond_5
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private fillLikeValues(Landroid/content/ContentValues;Lco/vine/android/api/VineLike;J)V
    .locals 3
    .param p1, "values"    # Landroid/content/ContentValues;
    .param p2, "like"    # Lco/vine/android/api/VineLike;
    .param p3, "lastRefresh"    # J

    .prologue
    .line 3107
    const-string v0, "like_id"

    iget-wide v1, p2, Lco/vine/android/api/VineLike;->likeId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3108
    const-string v0, "user_id"

    iget-wide v1, p2, Lco/vine/android/api/VineLike;->userId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3109
    const-string v0, "post_id"

    iget-wide v1, p2, Lco/vine/android/api/VineLike;->postId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3110
    const-string v0, "avatar_url"

    iget-object v1, p2, Lco/vine/android/api/VineLike;->avatarUrl:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3111
    const-string v0, "timestamp"

    iget-wide v1, p2, Lco/vine/android/api/VineLike;->created:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3112
    const-string v0, "location"

    iget-object v1, p2, Lco/vine/android/api/VineLike;->location:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3113
    const-string v0, "username"

    iget-object v1, p2, Lco/vine/android/api/VineLike;->username:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3114
    const-string v0, "verified"

    iget v1, p2, Lco/vine/android/api/VineLike;->verified:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3115
    const-string v0, "last_refresh"

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3116
    return-void
.end method

.method private fillMessageValues(Landroid/content/ContentValues;JLco/vine/android/api/VinePrivateMessage;)V
    .locals 3
    .param p1, "values"    # Landroid/content/ContentValues;
    .param p2, "conversationRowId"    # J
    .param p4, "message"    # Lco/vine/android/api/VinePrivateMessage;

    .prologue
    .line 3147
    const-string v0, "conversation_row_id"

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3148
    const-string v0, "message_id"

    iget-wide v1, p4, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3149
    const-string v0, "user_row_id"

    iget-wide v1, p4, Lco/vine/android/api/VinePrivateMessage;->userId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3150
    const-string v0, "message"

    iget-object v1, p4, Lco/vine/android/api/VinePrivateMessage;->message:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3151
    const-string v0, "timestamp"

    iget-wide v1, p4, Lco/vine/android/api/VinePrivateMessage;->created:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3152
    iget-object v0, p4, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 3153
    const-string v0, "video_url"

    iget-object v1, p4, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3155
    :cond_0
    iget-object v0, p4, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 3156
    const-string v0, "thumbnail_url"

    iget-object v1, p4, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3158
    :cond_1
    const-string v0, "is_last"

    iget-boolean v1, p4, Lco/vine/android/api/VinePrivateMessage;->isLast:Z

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 3159
    const-string v0, "vanished"

    iget-boolean v1, p4, Lco/vine/android/api/VinePrivateMessage;->vanished:Z

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 3160
    const-string v0, "max_loops"

    iget v1, p4, Lco/vine/android/api/VinePrivateMessage;->maxLoops:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3161
    const-string v0, "vanished_date"

    iget-wide v1, p4, Lco/vine/android/api/VinePrivateMessage;->vanishedDate:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3162
    const-string v0, "ephemeral"

    iget-boolean v1, p4, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 3163
    const-string v0, "local_start_time"

    iget-wide v1, p4, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3164
    const-string v0, "post_id"

    iget-wide v1, p4, Lco/vine/android/api/VinePrivateMessage;->postId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3165
    const-string v0, "error_code"

    iget v1, p4, Lco/vine/android/api/VinePrivateMessage;->errorCode:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3166
    const-string v0, "error_reason"

    iget-object v1, p4, Lco/vine/android/api/VinePrivateMessage;->errorReason:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3167
    iget-object v0, p4, Lco/vine/android/api/VinePrivateMessage;->uploadPath:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 3168
    const-string v0, "upload_path"

    iget-object v1, p4, Lco/vine/android/api/VinePrivateMessage;->uploadPath:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3170
    :cond_2
    return-void
.end method

.method private fillNotificationValues(Landroid/content/ContentValues;Lco/vine/android/api/VineSingleNotification;Ljava/lang/String;)V
    .locals 3
    .param p1, "values"    # Landroid/content/ContentValues;
    .param p2, "notification"    # Lco/vine/android/api/VineSingleNotification;
    .param p3, "message"    # Ljava/lang/String;

    .prologue
    .line 3120
    const-string v0, "avatar_url"

    iget-object v1, p2, Lco/vine/android/api/VineSingleNotification;->avatarUrl:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3121
    const-string v0, "notification_id"

    iget-wide v1, p2, Lco/vine/android/api/VineSingleNotification;->notificationId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3122
    const-string v0, "notification_type"

    iget v1, p2, Lco/vine/android/api/VineSingleNotification;->notificationType:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3123
    const-string v0, "conversation_row_id"

    iget-wide v1, p2, Lco/vine/android/api/VineSingleNotification;->conversationRowId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3124
    const-string v0, "message"

    invoke-virtual {p1, v0, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3125
    return-void
.end method

.method private fillPostValues(Landroid/content/ContentValues;Lco/vine/android/api/VinePost;J)V
    .locals 3
    .param p1, "values"    # Landroid/content/ContentValues;
    .param p2, "post"    # Lco/vine/android/api/VinePost;
    .param p3, "lastRefresh"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 3074
    const-string v0, "avatar_url"

    iget-object v1, p2, Lco/vine/android/api/VinePost;->avatarUrl:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3075
    const-string v0, "description"

    iget-object v1, p2, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3076
    const-string v0, "foursquare_venue_id"

    iget-object v1, p2, Lco/vine/android/api/VinePost;->foursquareVenueId:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3077
    const-string v0, "metadata_flags"

    iget v1, p2, Lco/vine/android/api/VinePost;->metadataFlags:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3078
    const-string v0, "location"

    iget-object v1, p2, Lco/vine/android/api/VinePost;->location:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3079
    const-string v0, "post_flags"

    iget v1, p2, Lco/vine/android/api/VinePost;->postFlags:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3080
    const-string v0, "post_id"

    iget-wide v1, p2, Lco/vine/android/api/VinePost;->postId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3081
    const-string v0, "my_repost_id"

    iget-wide v1, p2, Lco/vine/android/api/VinePost;->myRepostId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3082
    const-string v0, "share_url"

    iget-object v1, p2, Lco/vine/android/api/VinePost;->shareUrl:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3083
    const-string v0, "thumbnail_url"

    iget-object v1, p2, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3084
    const-string v0, "video_url"

    iget-object v1, p2, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3085
    const-string v0, "video_low_uRL"

    iget-object v1, p2, Lco/vine/android/api/VinePost;->videoLowURL:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3086
    const-string v0, "timestamp"

    iget-wide v1, p2, Lco/vine/android/api/VinePost;->created:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3087
    const-string v0, "username"

    iget-object v1, p2, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3088
    const-string v0, "user_id"

    iget-wide v1, p2, Lco/vine/android/api/VinePost;->userId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3089
    const-string v0, "likes_count"

    iget v1, p2, Lco/vine/android/api/VinePost;->likesCount:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3090
    const-string v0, "reviners_count"

    iget v1, p2, Lco/vine/android/api/VinePost;->revinersCount:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3091
    const-string v0, "comments_count"

    iget v1, p2, Lco/vine/android/api/VinePost;->commentsCount:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3092
    const-string v0, "user_background_color"

    iget v1, p2, Lco/vine/android/api/VinePost;->userBackgroundColor:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3093
    const-string v0, "tags"

    invoke-static {p2}, Lco/vine/android/api/VinePost;->getBytesFromTags(Lco/vine/android/api/VinePost;)[B

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;[B)V

    .line 3094
    const-string v0, "loops"

    iget-wide v1, p2, Lco/vine/android/api/VinePost;->loops:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3095
    const-string v0, "velocity"

    iget-wide v1, p2, Lco/vine/android/api/VinePost;->velocity:D

    invoke-static {v1, v2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Double;)V

    .line 3096
    const-string v0, "on_fire"

    iget-boolean v1, p2, Lco/vine/android/api/VinePost;->onFire:Z

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 3097
    iget-object v0, p2, Lco/vine/android/api/VinePost;->venueData:Lco/vine/android/api/VineVenue;

    if-eqz v0, :cond_0

    .line 3098
    const-string v0, "venue_data"

    iget-object v1, p2, Lco/vine/android/api/VinePost;->venueData:Lco/vine/android/api/VineVenue;

    invoke-static {v1}, Lco/vine/android/util/Util;->toByteArray(Ljava/lang/Object;)[B

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;[B)V

    .line 3100
    :cond_0
    iget-object v0, p2, Lco/vine/android/api/VinePost;->entities:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    .line 3101
    const-string v0, "entities"

    iget-object v1, p2, Lco/vine/android/api/VinePost;->entities:Ljava/util/ArrayList;

    invoke-static {v1}, Lco/vine/android/util/Util;->toByteArray(Ljava/lang/Object;)[B

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;[B)V

    .line 3103
    :cond_1
    const-string v0, "last_refresh"

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3104
    return-void
.end method

.method private fillTagValues(Landroid/content/ContentValues;Lco/vine/android/api/VineTag;)V
    .locals 3
    .param p1, "values"    # Landroid/content/ContentValues;
    .param p2, "tag"    # Lco/vine/android/api/VineTag;

    .prologue
    .line 3173
    const-string v0, "tag_id"

    iget-wide v1, p2, Lco/vine/android/api/VineTag;->tagId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3174
    const-string v0, "tag_name"

    iget-object v1, p2, Lco/vine/android/api/VineTag;->tagName:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3175
    const-string v0, "last_used_timestamp"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3176
    return-void
.end method

.method private fillUserContentValues(Landroid/content/ContentValues;Lco/vine/android/api/VineUser;J)V
    .locals 4
    .param p1, "values"    # Landroid/content/ContentValues;
    .param p2, "user"    # Lco/vine/android/api/VineUser;
    .param p3, "lastRefresh"    # J

    .prologue
    const/4 v3, -0x1

    .line 3041
    const-string v0, "user_id"

    iget-wide v1, p2, Lco/vine/android/api/VineUser;->userId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3042
    const-string v0, "avatar_url"

    iget-object v1, p2, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3043
    const-string v0, "username"

    iget-object v1, p2, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3044
    const-string v0, "blocked"

    iget v1, p2, Lco/vine/android/api/VineUser;->blocked:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3045
    const-string v0, "blocking"

    iget v1, p2, Lco/vine/android/api/VineUser;->blocking:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3046
    const-string v0, "description"

    iget-object v1, p2, Lco/vine/android/api/VineUser;->description:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3047
    const-string v0, "location"

    iget-object v1, p2, Lco/vine/android/api/VineUser;->location:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3048
    const-string v0, "explicit"

    iget v1, p2, Lco/vine/android/api/VineUser;->explicit:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3049
    const-string v0, "follower_count"

    iget v1, p2, Lco/vine/android/api/VineUser;->followerCount:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3050
    const-string v0, "following_count"

    iget v1, p2, Lco/vine/android/api/VineUser;->followingCount:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3051
    iget-object v0, p2, Lco/vine/android/api/VineUser;->email:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 3052
    const-string v0, "email_address"

    iget-object v1, p2, Lco/vine/android/api/VineUser;->email:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3054
    :cond_0
    iget-object v0, p2, Lco/vine/android/api/VineUser;->phoneNumber:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 3055
    const-string v0, "phone_number"

    iget-object v1, p2, Lco/vine/android/api/VineUser;->phoneNumber:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3057
    :cond_1
    iget v0, p2, Lco/vine/android/api/VineUser;->following:I

    if-eq v0, v3, :cond_2

    .line 3058
    const-string v0, "following_flag"

    iget v1, p2, Lco/vine/android/api/VineUser;->following:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3060
    :cond_2
    const-string v0, "like_count"

    iget v1, p2, Lco/vine/android/api/VineUser;->likeCount:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3061
    const-string v0, "post_count"

    iget v1, p2, Lco/vine/android/api/VineUser;->postCount:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3062
    const-string v0, "loop_count"

    iget-wide v1, p2, Lco/vine/android/api/VineUser;->loopCount:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3063
    const-string v0, "verified"

    iget v1, p2, Lco/vine/android/api/VineUser;->verified:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3064
    const-string v0, "follow_status"

    iget v1, p2, Lco/vine/android/api/VineUser;->followStatus:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3065
    const-string v0, "last_refresh"

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3066
    iget v0, p2, Lco/vine/android/api/VineUser;->profileBackground:I

    if-le v0, v3, :cond_3

    .line 3067
    const-string v0, "profile_background"

    iget v1, p2, Lco/vine/android/api/VineUser;->profileBackground:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3069
    :cond_3
    const-string v1, "accepts_oon_conversations"

    iget-boolean v0, p2, Lco/vine/android/api/VineUser;->acceptsOutOfNetworkConversations:Z

    if-eqz v0, :cond_4

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3070
    return-void

    .line 3069
    :cond_4
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static declared-synchronized getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineDatabaseHelper;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 113
    const-class v3, Lco/vine/android/provider/VineDatabaseHelper;

    monitor-enter v3

    const/4 v2, 0x1

    :try_start_0
    invoke-static {v2}, Lco/vine/android/provider/VineDatabaseHelper;->getDatabaseName(I)Ljava/lang/String;

    move-result-object v0

    .line 114
    .local v0, "databaseName":Ljava/lang/String;
    sget-object v2, Lco/vine/android/provider/VineDatabaseHelper;->sHelperMap:Ljava/util/HashMap;

    invoke-virtual {v2, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/provider/VineDatabaseHelper;

    .line 115
    .local v1, "helper":Lco/vine/android/provider/VineDatabaseHelper;
    if-nez v1, :cond_0

    .line 116
    new-instance v1, Lco/vine/android/provider/VineDatabaseHelper;

    .end local v1    # "helper":Lco/vine/android/provider/VineDatabaseHelper;
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lco/vine/android/provider/VineDatabaseHelper;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 117
    .restart local v1    # "helper":Lco/vine/android/provider/VineDatabaseHelper;
    sget-object v2, Lco/vine/android/provider/VineDatabaseHelper;->sHelperMap:Ljava/util/HashMap;

    invoke-virtual {v2, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 119
    :cond_0
    monitor-exit v3

    return-object v1

    .line 113
    .end local v0    # "databaseName":Ljava/lang/String;
    .end local v1    # "helper":Lco/vine/android/provider/VineDatabaseHelper;
    :catchall_0
    move-exception v2

    monitor-exit v3

    throw v2
.end method

.method public static getDatabaseName(I)Ljava/lang/String;
    .locals 2
    .param p0, "schemaVersion"    # I

    .prologue
    .line 3206
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "vine-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getDatabasePath(Landroid/content/Context;)Ljava/io/File;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 123
    const/4 v0, 0x1

    invoke-static {v0}, Lco/vine/android/provider/VineDatabaseHelper;->getDatabaseName(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/content/Context;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    return-object v0
.end method

.method private getLastChannelRowId()J
    .locals 10

    .prologue
    const/4 v3, 0x0

    .line 2963
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2964
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "channels"

    sget-object v2, Lco/vine/android/provider/VineDatabaseSQL$ChannelsQuery;->PROJECTION:[Ljava/lang/String;

    const-string v7, "channel_id DESC"

    const-string v8, "1"

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 2967
    .local v9, "cursor":Landroid/database/Cursor;
    if-eqz v9, :cond_1

    .line 2969
    :try_start_0
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2970
    const/4 v1, 0x0

    invoke-interface {v9, v1}, Landroid/database/Cursor;->getLong(I)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v1

    .line 2973
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 2976
    :goto_0
    return-wide v1

    .line 2973
    :cond_0
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 2976
    :cond_1
    const-wide/16 v1, 0x0

    goto :goto_0

    .line 2973
    :catchall_0
    move-exception v1

    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method private getLastCommentRowId(J)J
    .locals 10
    .param p1, "postId"    # J

    .prologue
    const/4 v5, 0x0

    const/4 v7, 0x0

    .line 2912
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2913
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "comments"

    sget-object v2, Lco/vine/android/provider/VineDatabaseSQL$CommentsQuery;->PROJECTION:[Ljava/lang/String;

    const-string v3, "post_id =? "

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v7

    const-string v7, "comment_id ASC"

    const-string v8, "1"

    move-object v6, v5

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 2916
    .local v9, "cursor":Landroid/database/Cursor;
    if-eqz v9, :cond_1

    .line 2918
    :try_start_0
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2919
    const/4 v1, 0x0

    invoke-interface {v9, v1}, Landroid/database/Cursor;->getLong(I)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v1

    .line 2922
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 2925
    :goto_0
    return-wide v1

    .line 2922
    :cond_0
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 2925
    :cond_1
    const-wide/16 v1, 0x0

    goto :goto_0

    .line 2922
    :catchall_0
    move-exception v1

    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method private getLastConversationId(I)J
    .locals 11
    .param p1, "networkType"    # I

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    const/4 v7, 0x0

    .line 2980
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2981
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v10, "last_message>0 AND network_type =? "

    .line 2982
    .local v10, "selection":Ljava/lang/String;
    const-string v1, "conversations"

    new-array v2, v4, [Ljava/lang/String;

    const-string v3, "_id"

    aput-object v3, v2, v7

    const-string v3, "last_message>0 AND network_type =? "

    new-array v4, v4, [Ljava/lang/String;

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v7

    const-string v7, "last_message_timestamp ASC, _id DESC"

    const-string v8, "1"

    move-object v6, v5

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 2986
    .local v9, "cursor":Landroid/database/Cursor;
    if-eqz v9, :cond_1

    .line 2988
    :try_start_0
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2989
    const/4 v1, 0x0

    invoke-interface {v9, v1}, Landroid/database/Cursor;->getLong(I)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v1

    .line 2992
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 2995
    :goto_0
    return-wide v1

    .line 2992
    :cond_0
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 2995
    :cond_1
    const-wide/16 v1, 0x0

    goto :goto_0

    .line 2992
    :catchall_0
    move-exception v1

    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method private getLastMessageRowId(J)J
    .locals 10
    .param p1, "conversationRowId"    # J

    .prologue
    const/4 v5, 0x0

    const/4 v7, 0x0

    .line 2929
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2930
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "messages"

    sget-object v2, Lco/vine/android/provider/VineDatabaseSQL$MessagesQuery;->PROJECTION:[Ljava/lang/String;

    const-string v3, "conversation_row_id =? AND deleted != 1 "

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v7

    const-string v7, "message_id ASC"

    const-string v8, "1"

    move-object v6, v5

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 2933
    .local v9, "cursor":Landroid/database/Cursor;
    if-eqz v9, :cond_1

    .line 2935
    :try_start_0
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2936
    const/4 v1, 0x0

    invoke-interface {v9, v1}, Landroid/database/Cursor;->getLong(I)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v1

    .line 2939
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 2942
    :goto_0
    return-wide v1

    .line 2939
    :cond_0
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 2942
    :cond_1
    const-wide/16 v1, 0x0

    goto :goto_0

    .line 2939
    :catchall_0
    move-exception v1

    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method private getLastPostRowId(ILjava/lang/String;)J
    .locals 10
    .param p1, "type"    # I
    .param p2, "tag"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    const/4 v7, 0x0

    .line 2893
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2894
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "post_comments_likes_view"

    sget-object v2, Lco/vine/android/provider/VineDatabaseSQL$PostCommentsLikesQuery;->PROJECTION:[Ljava/lang/String;

    const-string v3, "post_type=? AND tag=?"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/String;

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v7

    const/4 v6, 0x1

    aput-object p2, v4, v6

    const-string v7, "sort_id ASC"

    const-string v8, "1"

    move-object v6, v5

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 2899
    .local v9, "cursor":Landroid/database/Cursor;
    if-eqz v9, :cond_1

    .line 2901
    :try_start_0
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2902
    const/4 v1, 0x0

    invoke-interface {v9, v1}, Landroid/database/Cursor;->getLong(I)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v1

    .line 2905
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 2908
    :goto_0
    return-wide v1

    .line 2905
    :cond_0
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 2908
    :cond_1
    const-wide/16 v1, 0x0

    goto :goto_0

    .line 2905
    :catchall_0
    move-exception v1

    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method private getLastTagRowId()J
    .locals 10

    .prologue
    const/4 v3, 0x0

    .line 2946
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2947
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "tag_search_results"

    sget-object v2, Lco/vine/android/provider/VineDatabaseSQL$TagsQuery;->PROJECTION:[Ljava/lang/String;

    const-string v7, "_id DESC"

    const-string v8, "1"

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 2950
    .local v9, "cursor":Landroid/database/Cursor;
    if-eqz v9, :cond_1

    .line 2952
    :try_start_0
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2953
    const/4 v1, 0x0

    invoke-interface {v9, v1}, Landroid/database/Cursor;->getLong(I)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v1

    .line 2956
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 2959
    :goto_0
    return-wide v1

    .line 2956
    :cond_0
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 2959
    :cond_1
    const-wide/16 v1, 0x0

    goto :goto_0

    .line 2956
    :catchall_0
    move-exception v1

    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method private getLastUserRowId(ILjava/lang/String;Ljava/lang/String;)J
    .locals 10
    .param p1, "type"    # I
    .param p2, "tag"    # Ljava/lang/String;
    .param p3, "isLastOrdering"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    const/4 v6, 0x1

    const/4 v2, 0x0

    .line 2867
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2870
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    if-eqz p2, :cond_0

    .line 2871
    const-string v3, "type=? AND tag=?"

    .line 2872
    .local v3, "selection":Ljava/lang/String;
    const/4 v1, 0x2

    new-array v4, v1, [Ljava/lang/String;

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v2

    aput-object p2, v4, v6

    .line 2878
    .local v4, "selectionArgs":[Ljava/lang/String;
    :goto_0
    const-string v1, "user_groups_view"

    sget-object v2, Lco/vine/android/provider/VineDatabaseSQL$UsersQuery;->PROJECTION:[Ljava/lang/String;

    const-string v8, "1"

    move-object v6, v5

    move-object v7, p3

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 2880
    .local v9, "cursor":Landroid/database/Cursor;
    if-eqz v9, :cond_2

    .line 2882
    :try_start_0
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 2883
    const/4 v1, 0x0

    invoke-interface {v9, v1}, Landroid/database/Cursor;->getLong(I)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v1

    .line 2886
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 2889
    :goto_1
    return-wide v1

    .line 2874
    .end local v3    # "selection":Ljava/lang/String;
    .end local v4    # "selectionArgs":[Ljava/lang/String;
    .end local v9    # "cursor":Landroid/database/Cursor;
    :cond_0
    const-string v3, "type=?"

    .line 2875
    .restart local v3    # "selection":Ljava/lang/String;
    new-array v4, v6, [Ljava/lang/String;

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v2

    .restart local v4    # "selectionArgs":[Ljava/lang/String;
    goto :goto_0

    .line 2886
    .restart local v9    # "cursor":Landroid/database/Cursor;
    :cond_1
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 2889
    :cond_2
    const-wide/16 v1, 0x0

    goto :goto_1

    .line 2886
    :catchall_0
    move-exception v1

    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method private declared-synchronized mergePostGroups(Ljava/util/Collection;ILjava/lang/String;Lco/vine/android/util/LongSparseArray;)V
    .locals 16
    .param p2, "type"    # I
    .param p3, "groupTag"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lco/vine/android/api/VinePost;",
            ">;I",
            "Ljava/lang/String;",
            "Lco/vine/android/util/LongSparseArray",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1832
    .local p1, "posts":Ljava/util/Collection;, "Ljava/util/Collection<Lco/vine/android/api/VinePost;>;"
    .local p4, "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    monitor-enter p0

    if-eqz p1, :cond_0

    const/4 v2, -0x1

    move/from16 v0, p2

    if-ne v0, v2, :cond_1

    .line 1898
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 1836
    :cond_1
    :try_start_0
    sget-boolean v2, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v2, :cond_2

    .line 1837
    const-string v2, "VineDH"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "mergePostGroups: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->size()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", tagged by: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", of type: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move/from16 v0, p2

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1842
    :cond_2
    new-instance v11, Ljava/util/LinkedHashMap;

    invoke-direct {v11}, Ljava/util/LinkedHashMap;-><init>()V

    .line 1843
    .local v11, "newPostGroups":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/Long;Lco/vine/android/api/VinePost;>;"
    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v10

    .local v10, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lco/vine/android/api/VinePost;

    .line 1844
    .local v14, "post":Lco/vine/android/api/VinePost;
    iget-wide v2, v14, Lco/vine/android/api/VinePost;->postId:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v11, v2, v14}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 1832
    .end local v10    # "i$":Ljava/util/Iterator;
    .end local v11    # "newPostGroups":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/Long;Lco/vine/android/api/VinePost;>;"
    .end local v14    # "post":Lco/vine/android/api/VinePost;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 1848
    .restart local v10    # "i$":Ljava/util/Iterator;
    .restart local v11    # "newPostGroups":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/Long;Lco/vine/android/api/VinePost;>;"
    :cond_3
    :try_start_1
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 1849
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v2, "post_groups"

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$PostGroupsQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "post_type=?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static/range {p2 .. p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 1853
    .local v9, "cursor":Landroid/database/Cursor;
    if-eqz v9, :cond_5

    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v2

    if-eqz v2, :cond_5

    .line 1857
    :cond_4
    const/4 v2, 0x0

    :try_start_2
    invoke-interface {v9, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v11, v2}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1858
    invoke-interface {v9}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result v2

    if-nez v2, :cond_4

    .line 1860
    :try_start_3
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 1864
    :cond_5
    const/4 v13, 0x0

    .line 1865
    .local v13, "numInserted":I
    invoke-virtual {v11}, Ljava/util/LinkedHashMap;->size()I

    move-result v12

    .line 1866
    .local v12, "newPostGroupsCount":I
    if-lez v12, :cond_a

    .line 1868
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1870
    :try_start_4
    new-instance v15, Landroid/content/ContentValues;

    invoke-direct {v15}, Landroid/content/ContentValues;-><init>()V

    .line 1871
    .local v15, "values":Landroid/content/ContentValues;
    const-string v2, "post_type"

    invoke-static/range {p2 .. p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v15, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1872
    const-string v2, "tag"

    move-object/from16 v0, p3

    invoke-virtual {v15, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1873
    invoke-virtual {v11}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :goto_2
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_9

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lco/vine/android/api/VinePost;

    .line 1874
    .restart local v14    # "post":Lco/vine/android/api/VinePost;
    const-string v2, "g_flags"

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v15, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1875
    const-string v2, "post_id"

    iget-wide v3, v14, Lco/vine/android/api/VinePost;->postId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v15, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1876
    const-string v2, "repost_data"

    iget-object v3, v14, Lco/vine/android/api/VinePost;->repost:Lco/vine/android/api/VineRepost;

    invoke-static {v3}, Lco/vine/android/util/Util;->toByteArray(Ljava/lang/Object;)[B

    move-result-object v3

    invoke-virtual {v15, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;[B)V

    .line 1877
    iget-object v2, v14, Lco/vine/android/api/VinePost;->repost:Lco/vine/android/api/VineRepost;

    if-eqz v2, :cond_7

    .line 1878
    const-string v2, "reposter_id"

    iget-object v3, v14, Lco/vine/android/api/VinePost;->repost:Lco/vine/android/api/VineRepost;

    iget-wide v3, v3, Lco/vine/android/api/VineRepost;->userId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v15, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1882
    :goto_3
    if-eqz p4, :cond_6

    .line 1883
    const-string v3, "sort_id"

    iget-wide v4, v14, Lco/vine/android/api/VinePost;->postId:J

    move-object/from16 v0, p4

    invoke-virtual {v0, v4, v5}, Lco/vine/android/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v15, v3, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1885
    :cond_6
    const-string v2, "post_groups"

    const-string v3, "post_id"

    invoke-virtual {v1, v2, v3, v15}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-lez v2, :cond_8

    const/4 v2, 0x1

    :goto_4
    add-int/2addr v13, v2

    .line 1887
    goto :goto_2

    .line 1860
    .end local v12    # "newPostGroupsCount":I
    .end local v13    # "numInserted":I
    .end local v14    # "post":Lco/vine/android/api/VinePost;
    .end local v15    # "values":Landroid/content/ContentValues;
    :catchall_1
    move-exception v2

    :try_start_5
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    throw v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 1880
    .restart local v12    # "newPostGroupsCount":I
    .restart local v13    # "numInserted":I
    .restart local v14    # "post":Lco/vine/android/api/VinePost;
    .restart local v15    # "values":Landroid/content/ContentValues;
    :cond_7
    :try_start_6
    const-string v2, "reposter_id"

    invoke-virtual {v15, v2}, Landroid/content/ContentValues;->remove(Ljava/lang/String;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    goto :goto_3

    .line 1890
    .end local v14    # "post":Lco/vine/android/api/VinePost;
    .end local v15    # "values":Landroid/content/ContentValues;
    :catchall_2
    move-exception v2

    :try_start_7
    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v2
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 1885
    .restart local v14    # "post":Lco/vine/android/api/VinePost;
    .restart local v15    # "values":Landroid/content/ContentValues;
    :cond_8
    const/4 v2, 0x0

    goto :goto_4

    .line 1888
    .end local v14    # "post":Lco/vine/android/api/VinePost;
    :cond_9
    :try_start_8
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_2

    .line 1890
    :try_start_9
    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 1892
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v3, Lco/vine/android/provider/Vine$PostGroupsView;->CONTENT_URI:Landroid/net/Uri;

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 1895
    .end local v15    # "values":Landroid/content/ContentValues;
    :cond_a
    sget-boolean v2, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v2, :cond_0

    .line 1896
    const-string v2, "VineDH"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Inserted new post groups: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " of type "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move/from16 v0, p2

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    goto/16 :goto_0
.end method

.method private declared-synchronized mergeUserGroups(Ljava/util/Collection;ILjava/lang/String;Lco/vine/android/util/LongSparseArray;Lco/vine/android/util/LongSparseArray;)V
    .locals 16
    .param p2, "type"    # I
    .param p3, "groupTag"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;I",
            "Ljava/lang/String;",
            "Lco/vine/android/util/LongSparseArray",
            "<",
            "Ljava/lang/Long;",
            ">;",
            "Lco/vine/android/util/LongSparseArray",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1747
    .local p1, "users":Ljava/util/Collection;, "Ljava/util/Collection<Lco/vine/android/api/VineUser;>;"
    .local p4, "tagMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    .local p5, "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    monitor-enter p0

    if-eqz p1, :cond_0

    const/4 v2, -0x1

    move/from16 v0, p2

    if-ne v0, v2, :cond_1

    .line 1828
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 1751
    :cond_1
    :try_start_0
    sget-boolean v2, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v2, :cond_2

    .line 1752
    const-string v2, "VineDH"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "mergeUserGroups: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->size()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", tagged by: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", of type: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move/from16 v0, p2

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1757
    :cond_2
    new-instance v12, Ljava/util/LinkedHashMap;

    invoke-direct {v12}, Ljava/util/LinkedHashMap;-><init>()V

    .line 1758
    .local v12, "newUserGroupsMap":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/Long;Lco/vine/android/api/VineUser;>;"
    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v10

    .local v10, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lco/vine/android/api/VineUser;

    .line 1759
    .local v14, "user":Lco/vine/android/api/VineUser;
    iget-wide v2, v14, Lco/vine/android/api/VineUser;->userId:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v12, v2, v14}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 1747
    .end local v10    # "i$":Ljava/util/Iterator;
    .end local v12    # "newUserGroupsMap":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/Long;Lco/vine/android/api/VineUser;>;"
    .end local v14    # "user":Lco/vine/android/api/VineUser;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 1763
    .restart local v10    # "i$":Ljava/util/Iterator;
    .restart local v12    # "newUserGroupsMap":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/Long;Lco/vine/android/api/VineUser;>;"
    :cond_3
    :try_start_1
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 1766
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    if-eqz p3, :cond_4

    .line 1767
    const-string v2, "user_groups"

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$UserGroupsQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "type=? AND tag=?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static/range {p2 .. p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-static/range {p3 .. p3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v9

    .line 1781
    .local v9, "cursor":Landroid/database/Cursor;
    :goto_2
    if-eqz v9, :cond_0

    .line 1786
    :goto_3
    :try_start_2
    invoke-interface {v9}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_5

    .line 1788
    const/4 v2, 0x0

    invoke-interface {v9, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v12, v2}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_3

    .line 1791
    :catchall_1
    move-exception v2

    :try_start_3
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    throw v2

    .line 1774
    .end local v9    # "cursor":Landroid/database/Cursor;
    :cond_4
    const-string v2, "user_groups"

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$UserGroupsQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "type=?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static/range {p2 .. p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .restart local v9    # "cursor":Landroid/database/Cursor;
    goto :goto_2

    .line 1791
    :cond_5
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 1794
    sget-boolean v2, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v2, :cond_6

    .line 1795
    const-string v2, "VineDH"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Inserting new user groups: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v12}, Ljava/util/LinkedHashMap;->size()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1798
    :cond_6
    invoke-virtual {v12}, Ljava/util/LinkedHashMap;->size()I

    move-result v11

    .line 1799
    .local v11, "newUserGroupsCount":I
    if-lez v11, :cond_0

    .line 1801
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1803
    :try_start_4
    new-instance v15, Landroid/content/ContentValues;

    invoke-direct {v15}, Landroid/content/ContentValues;-><init>()V

    .line 1804
    .local v15, "values":Landroid/content/ContentValues;
    const-string v2, "type"

    invoke-static/range {p2 .. p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v15, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1806
    if-eqz p3, :cond_7

    .line 1807
    const-string v2, "tag"

    move-object/from16 v0, p3

    invoke-virtual {v15, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1809
    :cond_7
    if-eqz p5, :cond_9

    const/4 v13, 0x1

    .line 1810
    .local v13, "useOrdering":Z
    :goto_4
    invoke-virtual {v12}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :goto_5
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_b

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lco/vine/android/api/VineUser;

    .line 1812
    .restart local v14    # "user":Lco/vine/android/api/VineUser;
    const-string v2, "g_flags"

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v15, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1813
    const-string v2, "user_id"

    iget-wide v3, v14, Lco/vine/android/api/VineUser;->userId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v15, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1814
    if-eqz v13, :cond_a

    iget-wide v2, v14, Lco/vine/android/api/VineUser;->userId:J

    move-object/from16 v0, p5

    invoke-virtual {v0, v2, v3}, Lco/vine/android/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_a

    .line 1815
    const-string v3, "order_id"

    iget-wide v4, v14, Lco/vine/android/api/VineUser;->userId:J

    move-object/from16 v0, p5

    invoke-virtual {v0, v4, v5}, Lco/vine/android/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v15, v3, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1819
    :cond_8
    :goto_6
    const-string v2, "user_groups"

    const-string v3, "user_id"

    invoke-virtual {v1, v2, v3, v15}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    goto :goto_5

    .line 1823
    .end local v13    # "useOrdering":Z
    .end local v14    # "user":Lco/vine/android/api/VineUser;
    .end local v15    # "values":Landroid/content/ContentValues;
    :catchall_2
    move-exception v2

    :try_start_5
    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 1809
    .restart local v15    # "values":Landroid/content/ContentValues;
    :cond_9
    const/4 v13, 0x0

    goto :goto_4

    .line 1816
    .restart local v13    # "useOrdering":Z
    .restart local v14    # "user":Lco/vine/android/api/VineUser;
    :cond_a
    if-eqz p4, :cond_8

    :try_start_6
    iget-wide v2, v14, Lco/vine/android/api/VineUser;->userId:J

    move-object/from16 v0, p4

    invoke-virtual {v0, v2, v3}, Lco/vine/android/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_8

    .line 1817
    const-string v3, "tag"

    iget-wide v4, v14, Lco/vine/android/api/VineUser;->userId:J

    move-object/from16 v0, p4

    invoke-virtual {v0, v4, v5}, Lco/vine/android/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v15, v3, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    goto :goto_6

    .line 1821
    .end local v14    # "user":Lco/vine/android/api/VineUser;
    :cond_b
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    .line 1823
    :try_start_7
    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 1826
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v3, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI:Landroid/net/Uri;

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto/16 :goto_0
.end method

.method private mergetUserSection(Landroid/database/sqlite/SQLiteDatabase;Landroid/content/ContentValues;Lco/vine/android/api/VineUser;JI)V
    .locals 10
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "user"    # Lco/vine/android/api/VineUser;
    .param p4, "refresh"    # J
    .param p6, "sectionType"    # I

    .prologue
    .line 1429
    if-ltz p6, :cond_2

    .line 1430
    invoke-virtual {p2}, Landroid/content/ContentValues;->clear()V

    .line 1431
    const-string v0, "section_type"

    invoke-static/range {p6 .. p6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p2, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1432
    const-wide/16 v0, 0x0

    cmp-long v0, p4, v0

    if-lez v0, :cond_0

    .line 1433
    const-string v0, "last_section_refresh"

    invoke-static {p4, p5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p2, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1435
    :cond_0
    iget-wide v0, p3, Lco/vine/android/api/VineUser;->friendIndex:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_1

    .line 1436
    const-string v0, "section_index"

    iget-wide v1, p3, Lco/vine/android/api/VineUser;->friendIndex:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p2, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1438
    :cond_1
    const-string v0, "user_id"

    iget-wide v1, p3, Lco/vine/android/api/VineUser;->userId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p2, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1439
    const-string v0, "section_title"

    iget-object v1, p3, Lco/vine/android/api/VineUser;->sectionTitle:Ljava/lang/String;

    invoke-virtual {p2, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1441
    const-string v9, "user_id=? AND section_type=?"

    .line 1442
    .local v9, "where":Ljava/lang/String;
    const/4 v0, 0x2

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    iget-wide v1, p3, Lco/vine/android/api/VineUser;->userId:J

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v0

    const/4 v0, 0x1

    invoke-static/range {p6 .. p6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v0

    .line 1444
    .local v4, "whereArgs":[Ljava/lang/String;
    const-string v1, "user_sections"

    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v3, "_id"

    aput-object v3, v2, v0

    const-string v3, "user_id=? AND section_type=?"

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p1

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 1447
    .local v8, "query":Landroid/database/Cursor;
    if-eqz v8, :cond_2

    .line 1449
    :try_start_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1450
    const-string v0, "user_sections"

    const-string v1, "user_id=? AND section_type=?"

    invoke-virtual {p1, v0, p2, v1, v4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1455
    :goto_0
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 1461
    .end local v4    # "whereArgs":[Ljava/lang/String;
    .end local v8    # "query":Landroid/database/Cursor;
    .end local v9    # "where":Ljava/lang/String;
    :cond_2
    return-void

    .line 1452
    .restart local v4    # "whereArgs":[Ljava/lang/String;
    .restart local v8    # "query":Landroid/database/Cursor;
    .restart local v9    # "where":Ljava/lang/String;
    :cond_3
    :try_start_1
    const-string v0, "user_sections"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1, p2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 1455
    :catchall_0
    move-exception v0

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v0
.end method

.method private notifyByType(I)V
    .locals 3
    .param p1, "groupType"    # I

    .prologue
    const/4 v2, 0x0

    .line 3221
    packed-switch p1, :pswitch_data_0

    .line 3243
    :pswitch_0
    invoke-direct {p0}, Lco/vine/android/provider/VineDatabaseHelper;->notifyPostCommentsViewUris()V

    .line 3247
    :goto_0
    return-void

    .line 3223
    :pswitch_1
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v1, Lco/vine/android/provider/Vine$PostCommentsLikesView;->CONTENT_URI_ALL_TIMELINE_CHANNEL_POPULAR:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    goto :goto_0

    .line 3227
    :pswitch_2
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v1, Lco/vine/android/provider/Vine$PostCommentsLikesView;->CONTENT_URI_ALL_TIMELINE_CHANNEL_RECENT:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    goto :goto_0

    .line 3231
    :pswitch_3
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v1, Lco/vine/android/provider/Vine$PostCommentsLikesView;->CONTENT_URI_ALL_TIMELINE_ON_THE_RISE:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    goto :goto_0

    .line 3235
    :pswitch_4
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v1, Lco/vine/android/provider/Vine$PostCommentsLikesView;->CONTENT_URI_ALL_TIMELINE_POPULAR_NOW:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    goto :goto_0

    .line 3239
    :pswitch_5
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v1, Lco/vine/android/provider/Vine$PostCommentsLikesView;->CONTENT_URI_ALL_TIMELINE_TAG:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    goto :goto_0

    .line 3221
    :pswitch_data_0
    .packed-switch 0x4
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private notifyPostCommentsViewUris()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 3210
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v1, Lco/vine/android/provider/Vine$PostCommentsLikesView;->CONTENT_URI_ALL_TIMELINE:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 3212
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v1, Lco/vine/android/provider/Vine$PostCommentsLikesView;->CONTENT_URI_ALL_TIMELINE_USER:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 3214
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v1, Lco/vine/android/provider/Vine$PostCommentsLikesView;->CONTENT_URI_ALL_TIMELINE_USER_LIKES:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 3216
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v1, Lco/vine/android/provider/Vine$PostCommentsLikesView;->CONTENT_URI_ALL_TIMELINE_SINGLE:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 3218
    return-void
.end method

.method private notifyVMUris()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 2396
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v1, Lco/vine/android/provider/Vine$InboxView;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 2397
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v1, Lco/vine/android/provider/Vine$ConversationMessageUsersView;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 2398
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v1, Lco/vine/android/provider/Vine$Messages;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 2399
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v1, Lco/vine/android/provider/Vine$Conversations;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 2400
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v1, Lco/vine/android/provider/Vine$ConversationRecipients;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 2401
    return-void
.end method

.method private declared-synchronized removePostsFromGroup(I)I
    .locals 7
    .param p1, "type"    # I

    .prologue
    .line 1338
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v0

    .line 1341
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 1342
    const-string v2, "post_groups"

    const-string v3, "post_type=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v0, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 1344
    .local v1, "numGroups":I
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 1345
    sget-boolean v2, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v2, :cond_0

    .line 1346
    const-string v2, "VineDH"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Clearing group "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " deleting "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " groups "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1349
    :cond_0
    :try_start_2
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 1351
    monitor-exit p0

    return v1

    .line 1349
    .end local v1    # "numGroups":I
    :catchall_0
    move-exception v2

    :try_start_3
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 1338
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :catchall_1
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method private declared-synchronized removePostsFromGroupByPostId(IJ)I
    .locals 5
    .param p1, "type"    # I
    .param p2, "postId"    # J

    .prologue
    .line 1331
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 1332
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v2, "post_type=? AND post_id=?"

    .line 1333
    .local v2, "selection":Ljava/lang/String;
    const/4 v3, 0x2

    new-array v1, v3, [Ljava/lang/String;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v1, v3

    const/4 v3, 0x1

    invoke-static {p2, p3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v1, v3

    .line 1334
    .local v1, "selArgs":[Ljava/lang/String;
    const-string v3, "post_groups"

    const-string v4, "post_type=? AND post_id=?"

    invoke-virtual {v0, v3, v4, v1}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v3

    monitor-exit p0

    return v3

    .line 1331
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "selArgs":[Ljava/lang/String;
    .end local v2    # "selection":Ljava/lang/String;
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method private setValue(Ljava/lang/String;J)V
    .locals 3
    .param p1, "propName"    # Ljava/lang/String;
    .param p2, "value"    # J

    .prologue
    .line 3979
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 3980
    .local v0, "values":Landroid/content/ContentValues;
    const-string v1, "value"

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3981
    invoke-virtual {p0, p1, v0}, Lco/vine/android/provider/VineDatabaseHelper;->saveUserValue(Ljava/lang/String;Landroid/content/ContentValues;)I

    .line 3982
    return-void
.end method

.method private setValue(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "propName"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 3973
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 3974
    .local v0, "values":Landroid/content/ContentValues;
    const-string v1, "value"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3975
    invoke-virtual {p0, p1, v0}, Lco/vine/android/provider/VineDatabaseHelper;->saveUserValue(Ljava/lang/String;Landroid/content/ContentValues;)I

    .line 3976
    return-void
.end method


# virtual methods
.method public declared-synchronized addFollow(JJJZ)I
    .locals 20
    .param p1, "userId"    # J
    .param p3, "sessionOwnerId"    # J
    .param p5, "followId"    # J
    .param p7, "notify"    # Z

    .prologue
    .line 760
    monitor-enter p0

    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v3

    .line 762
    .local v3, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v4, 0x1

    new-array v7, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v7, v4

    .line 764
    .local v7, "whereArgs":[Ljava/lang/String;
    const-string v4, "users"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    const-string v8, "following_flag"

    aput-object v8, v5, v6

    const-string v6, "user_id=?"

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-virtual/range {v3 .. v10}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v14

    .line 767
    .local v14, "c":Landroid/database/Cursor;
    if-eqz v14, :cond_5

    .line 769
    :try_start_1
    invoke-interface {v14}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v4

    if-eqz v4, :cond_4

    .line 770
    const/4 v4, 0x0

    invoke-interface {v14, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v15

    .line 771
    .local v15, "currentFriendship":I
    const/4 v4, 0x1

    invoke-static {v15, v4}, Lco/vine/android/Friendships;->setFriendship(II)I

    move-result v17

    .line 774
    .local v17, "newFriendship":I
    new-instance v16, Landroid/content/ContentValues;

    invoke-direct/range {v16 .. v16}, Landroid/content/ContentValues;-><init>()V

    .line 775
    .local v16, "cv":Landroid/content/ContentValues;
    const-string v4, "following_flag"

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    move-object/from16 v0, v16

    invoke-virtual {v0, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 777
    const-string v4, "users"

    const-string v5, "user_id=?"

    move-object/from16 v0, v16

    invoke-virtual {v3, v4, v0, v5, v7}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v18

    .line 780
    .local v18, "result":I
    new-instance v19, Lco/vine/android/api/VineUser;

    invoke-direct/range {v19 .. v19}, Lco/vine/android/api/VineUser;-><init>()V

    .line 781
    .local v19, "skeletonUser":Lco/vine/android/api/VineUser;
    move-wide/from16 v0, p1

    move-object/from16 v2, v19

    iput-wide v0, v2, Lco/vine/android/api/VineUser;->userId:J

    .line 782
    new-instance v9, Ljava/util/ArrayList;

    const/4 v4, 0x1

    invoke-direct {v9, v4}, Ljava/util/ArrayList;-><init>(I)V

    .line 783
    .local v9, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    move-object/from16 v0, v19

    invoke-virtual {v9, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 784
    const/4 v13, 0x0

    .line 785
    .local v13, "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    const-wide/16 v4, 0x0

    cmp-long v4, p5, v4

    if-lez v4, :cond_0

    .line 786
    new-instance v13, Lco/vine/android/util/LongSparseArray;

    .end local v13    # "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    const/4 v4, 0x1

    invoke-direct {v13, v4}, Lco/vine/android/util/LongSparseArray;-><init>(I)V

    .line 787
    .restart local v13    # "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    invoke-static/range {p5 .. p6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    move-wide/from16 v0, p1

    invoke-virtual {v13, v0, v1, v4}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 789
    :cond_0
    const/4 v10, 0x1

    invoke-static/range {p3 .. p4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v11

    const/4 v12, 0x0

    move-object/from16 v8, p0

    invoke-direct/range {v8 .. v13}, Lco/vine/android/provider/VineDatabaseHelper;->mergeUserGroups(Ljava/util/Collection;ILjava/lang/String;Lco/vine/android/util/LongSparseArray;Lco/vine/android/util/LongSparseArray;)V

    .line 792
    if-eqz p7, :cond_1

    .line 793
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v5, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FOLLOWING:Landroid/net/Uri;

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 795
    :cond_1
    sget-boolean v4, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v4, :cond_2

    .line 796
    const-string v4, "VineDH"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Followed user "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-wide/from16 v0, p1

    invoke-virtual {v5, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 801
    :cond_2
    if-eqz v14, :cond_3

    .line 802
    :try_start_2
    invoke-interface {v14}, Landroid/database/Cursor;->close()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 806
    .end local v9    # "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    .end local v13    # "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    .end local v15    # "currentFriendship":I
    .end local v16    # "cv":Landroid/content/ContentValues;
    .end local v17    # "newFriendship":I
    .end local v18    # "result":I
    .end local v19    # "skeletonUser":Lco/vine/android/api/VineUser;
    :cond_3
    :goto_0
    monitor-exit p0

    return v18

    .line 801
    :cond_4
    if-eqz v14, :cond_5

    .line 802
    :try_start_3
    invoke-interface {v14}, Landroid/database/Cursor;->close()V

    .line 806
    :cond_5
    const/16 v18, -0x1

    goto :goto_0

    .line 801
    :catchall_0
    move-exception v4

    if-eqz v14, :cond_6

    .line 802
    invoke-interface {v14}, Landroid/database/Cursor;->close()V

    :cond_6
    throw v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 760
    .end local v3    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v7    # "whereArgs":[Ljava/lang/String;
    .end local v14    # "c":Landroid/database/Cursor;
    :catchall_1
    move-exception v4

    monitor-exit p0

    throw v4
.end method

.method public declared-synchronized addLike(Lco/vine/android/api/VineLike;Z)I
    .locals 17
    .param p1, "like"    # Lco/vine/android/api/VineLike;
    .param p2, "notify"    # Z

    .prologue
    .line 860
    monitor-enter p0

    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 862
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v2, 0x1

    new-array v5, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    move-object/from16 v0, p1

    iget-wide v3, v0, Lco/vine/android/api/VineLike;->postId:J

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v5, v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    .line 865
    .local v5, "whereArgs":[Ljava/lang/String;
    const/16 v16, 0x0

    .line 866
    .local v16, "result":I
    const/4 v15, 0x0

    .line 868
    .local v15, "mergeResult":I
    :try_start_1
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 871
    const-string v2, "posts"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v6, "metadata_flags"

    aput-object v6, v3, v4

    const-string v4, "post_id=?"

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v12

    .line 874
    .local v12, "c":Landroid/database/Cursor;
    if-eqz v12, :cond_1

    .line 876
    :try_start_2
    invoke-interface {v12}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 877
    new-instance v13, Landroid/content/ContentValues;

    invoke-direct {v13}, Landroid/content/ContentValues;-><init>()V

    .line 878
    .local v13, "cv":Landroid/content/ContentValues;
    const/4 v2, 0x0

    invoke-interface {v12, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v14

    .line 879
    .local v14, "flag":I
    or-int/lit8 v14, v14, 0x8

    .line 880
    const-string v2, "metadata_flags"

    invoke-static {v14}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v13, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 881
    const-string v2, "posts"

    const-string v3, "post_id=?"

    invoke-virtual {v1, v2, v13, v3, v5}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    if-lez v2, :cond_4

    const/16 v16, 0x1

    .line 883
    :goto_0
    sget-boolean v2, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v2, :cond_0

    .line 884
    const-string v2, "VineDH"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Updating like value in post: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p1

    iget-wide v8, v0, Lco/vine/android/api/VineLike;->postId:J

    invoke-virtual {v3, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 888
    .end local v13    # "cv":Landroid/content/ContentValues;
    .end local v14    # "flag":I
    :cond_0
    if-eqz v12, :cond_1

    .line 889
    :try_start_3
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    .line 895
    :cond_1
    new-instance v7, Ljava/util/ArrayList;

    const/4 v2, 0x1

    invoke-direct {v7, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 896
    .local v7, "likes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineLike;>;"
    move-object/from16 v0, p1

    invoke-virtual {v7, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 897
    move-object/from16 v0, p1

    iget-wide v8, v0, Lco/vine/android/api/VineLike;->postId:J

    const/4 v10, 0x0

    const/4 v11, 0x0

    move-object/from16 v6, p0

    invoke-virtual/range {v6 .. v11}, Lco/vine/android/provider/VineDatabaseHelper;->mergeLikes(Ljava/util/Collection;JII)I

    move-result v15

    .line 898
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 900
    :try_start_4
    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 902
    if-eqz p2, :cond_3

    if-gtz v16, :cond_2

    if-lez v15, :cond_3

    .line 903
    :cond_2
    invoke-direct/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->notifyPostCommentsViewUris()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 905
    :cond_3
    monitor-exit p0

    return v16

    .line 881
    .end local v7    # "likes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineLike;>;"
    .restart local v13    # "cv":Landroid/content/ContentValues;
    .restart local v14    # "flag":I
    :cond_4
    const/16 v16, 0x0

    goto :goto_0

    .line 888
    .end local v13    # "cv":Landroid/content/ContentValues;
    .end local v14    # "flag":I
    :catchall_0
    move-exception v2

    if-eqz v12, :cond_5

    .line 889
    :try_start_5
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    :cond_5
    throw v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 900
    .end local v12    # "c":Landroid/database/Cursor;
    :catchall_1
    move-exception v2

    :try_start_6
    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v2
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    .line 860
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v5    # "whereArgs":[Ljava/lang/String;
    .end local v15    # "mergeResult":I
    .end local v16    # "result":I
    :catchall_2
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public amFollowingUser(J)Z
    .locals 12
    .param p1, "userRowId"    # J

    .prologue
    const/4 v5, 0x0

    const/4 v10, 0x1

    const/4 v11, 0x0

    .line 3892
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3893
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "users"

    new-array v2, v10, [Ljava/lang/String;

    const-string v3, "following_flag"

    aput-object v3, v2, v11

    const-string v3, "_id =? "

    new-array v4, v10, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v11

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 3895
    .local v8, "c":Landroid/database/Cursor;
    const/4 v9, 0x0

    .line 3896
    .local v9, "following":Z
    if-eqz v8, :cond_1

    .line 3898
    :try_start_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 3899
    const/4 v1, 0x0

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getInt(I)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-ne v1, v10, :cond_2

    move v9, v10

    .line 3902
    :cond_0
    :goto_0
    if-eqz v8, :cond_1

    .line 3903
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 3907
    :cond_1
    return v9

    :cond_2
    move v9, v11

    .line 3899
    goto :goto_0

    .line 3902
    :catchall_0
    move-exception v1

    if-eqz v8, :cond_3

    .line 3903
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    :cond_3
    throw v1
.end method

.method public declared-synchronized cleanTagSearchResults()V
    .locals 5

    .prologue
    .line 540
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v0

    .line 541
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v1, 0x0

    .line 543
    .local v1, "deleted":I
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 545
    const-string v2, "tag_search_results"

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 547
    sget-boolean v2, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v2, :cond_0

    .line 548
    const-string v2, "VineDH"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Deleted "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " tag search result rows."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 550
    :cond_0
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 552
    :try_start_2
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 555
    if-lez v1, :cond_1

    .line 556
    iget-object v2, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v3, Lco/vine/android/provider/Vine$TagSearchResults;->CONTENT_URI:Landroid/net/Uri;

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 558
    :cond_1
    monitor-exit p0

    return-void

    .line 552
    :catchall_0
    move-exception v2

    :try_start_3
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 540
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "deleted":I
    :catchall_1
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized cleanUp(J)I
    .locals 7
    .param p1, "timeAnchor"    # J

    .prologue
    .line 491
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v0

    .line 492
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v1, 0x0

    .line 494
    .local v1, "deleted":I
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 495
    const-string v2, "DELETE FROM post_groups WHERE post_id IN (SELECT post_id FROM posts WHERE last_refresh < ?);"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 499
    const-string v2, "posts"

    const-string v3, "last_refresh<?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v0, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 502
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 503
    sget-boolean v2, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v2, :cond_0

    .line 504
    const-string v2, "VineDH"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Cleanup performed, deleted "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " posts with last_refresh less "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "than anchor: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 508
    :cond_0
    :try_start_2
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 511
    if-lez v1, :cond_1

    .line 512
    invoke-direct {p0}, Lco/vine/android/provider/VineDatabaseHelper;->notifyPostCommentsViewUris()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 514
    :cond_1
    monitor-exit p0

    return v1

    .line 508
    :catchall_0
    move-exception v2

    :try_start_3
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 491
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "deleted":I
    :catchall_1
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized cleanUserSearchResults()V
    .locals 7

    .prologue
    .line 518
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v0

    .line 519
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v1, 0x0

    .line 521
    .local v1, "deleted":I
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 523
    const-string v2, "user_groups"

    const-string v3, "type=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const/16 v6, 0x8

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v0, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 526
    sget-boolean v2, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v2, :cond_0

    .line 527
    const-string v2, "VineDH"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Deleted "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " user search result rows."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 529
    :cond_0
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 531
    :try_start_2
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 534
    if-lez v1, :cond_1

    .line 535
    iget-object v2, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v3, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_USER_SEARCH_RESULTS:Landroid/net/Uri;

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 537
    :cond_1
    monitor-exit p0

    return-void

    .line 531
    :catchall_0
    move-exception v2

    :try_start_3
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 518
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "deleted":I
    :catchall_1
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized clearAllData()V
    .locals 4

    .prologue
    .line 2815
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2816
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "settings"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2817
    const-string v1, "user_groups"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2818
    const-string v1, "posts"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2819
    const-string v1, "likes"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2820
    const-string v1, "post_groups"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2821
    const-string v1, "comments"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2822
    const-string v1, "page_cursors"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2823
    const-string v1, "tag_search_results"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2824
    const-string v1, "channels"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2825
    const-string v1, "notifications"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2826
    const-string v1, "tag_recently_used"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2827
    const-string v1, "messages"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2828
    const-string v1, "conversation_recipients"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2829
    const-string v1, "conversations"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2830
    monitor-exit p0

    return-void

    .line 2815
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized clearCachedData()V
    .locals 4

    .prologue
    .line 2836
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v0

    .line 2838
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 2839
    const-string v1, "users"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2840
    const-string v1, "user_groups"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2841
    const-string v1, "posts"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2842
    const-string v1, "likes"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2843
    const-string v1, "post_groups"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2844
    const-string v1, "comments"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2845
    const-string v1, "page_cursors"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2846
    const-string v1, "tag_search_results"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2847
    const-string v1, "channels"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2848
    const-string v1, "notifications"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2849
    const-string v1, "tag_recently_used"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2850
    const-string v1, "messages"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2851
    const-string v1, "conversation_recipients"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2852
    const-string v1, "conversations"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2853
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2855
    :try_start_2
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2857
    monitor-exit p0

    return-void

    .line 2855
    :catchall_0
    move-exception v1

    :try_start_3
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 2836
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :catchall_1
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized clearCachedData(Z)V
    .locals 1
    .param p1, "notify"    # Z

    .prologue
    .line 2860
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->clearCachedData()V

    .line 2861
    if-eqz p1, :cond_0

    .line 2862
    invoke-direct {p0}, Lco/vine/android/provider/VineDatabaseHelper;->notifyPostCommentsViewUris()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2864
    :cond_0
    monitor-exit p0

    return-void

    .line 2860
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public clearFileCache()V
    .locals 1

    .prologue
    .line 913
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mAppContext:Landroid/content/Context;

    invoke-static {v0}, Lco/vine/android/util/Util;->removeCache(Landroid/content/Context;)V

    .line 914
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mAppContext:Landroid/content/Context;

    invoke-static {v0}, Lco/vine/android/util/image/ImageUtils;->removeFiles(Landroid/content/Context;)V

    .line 915
    return-void
.end method

.method public declared-synchronized clearUnreadCount(J)V
    .locals 8
    .param p1, "conversationRowId"    # J

    .prologue
    .line 3383
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v0

    .line 3384
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v1, 0x0

    .line 3387
    .local v1, "updated":I
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 3388
    new-instance v2, Landroid/content/ContentValues;

    const/4 v5, 0x1

    invoke-direct {v2, v5}, Landroid/content/ContentValues;-><init>(I)V

    .line 3389
    .local v2, "values":Landroid/content/ContentValues;
    const-string v5, "unread_message_count"

    const/4 v6, 0x0

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v2, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3390
    const-string v4, "_id=?"

    .line 3391
    .local v4, "whereClause":Ljava/lang/String;
    const/4 v5, 0x1

    new-array v3, v5, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v3, v5

    .line 3392
    .local v3, "whereArgs":[Ljava/lang/String;
    const-string v5, "conversations"

    const-string v6, "_id=?"

    invoke-virtual {v0, v5, v2, v6, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 3393
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 3395
    :try_start_2
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 3398
    if-lez v1, :cond_0

    .line 3399
    iget-object v5, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v6, Lco/vine/android/provider/Vine$ConversationMessageUsersView;->CONTENT_URI:Landroid/net/Uri;

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 3400
    iget-object v5, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v6, Lco/vine/android/provider/Vine$InboxView;->CONTENT_URI:Landroid/net/Uri;

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 3402
    :cond_0
    monitor-exit p0

    return-void

    .line 3395
    .end local v2    # "values":Landroid/content/ContentValues;
    .end local v3    # "whereArgs":[Ljava/lang/String;
    .end local v4    # "whereClause":Ljava/lang/String;
    :catchall_0
    move-exception v5

    :try_start_3
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v5
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 3383
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "updated":I
    :catchall_1
    move-exception v5

    monitor-exit p0

    throw v5
.end method

.method public declared-synchronized createConversationRowId(Ljava/util/HashSet;I)J
    .locals 12
    .param p2, "networkType"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/Long;",
            ">;I)J"
        }
    .end annotation

    .prologue
    .line 3535
    .local p1, "userRowIds":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/Long;>;"
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v11

    .line 3537
    .local v11, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-wide/16 v9, -0x1

    .line 3539
    .local v9, "conversationRowId":J
    :try_start_1
    invoke-virtual {v11}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 3540
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 3541
    .local v1, "values":Landroid/content/ContentValues;
    const-wide/16 v2, -0x1

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    const-wide/16 v5, 0x0

    const-wide/16 v7, 0x0

    move-object v0, p0

    invoke-direct/range {v0 .. v8}, Lco/vine/android/provider/VineDatabaseHelper;->fillConversationValues(Landroid/content/ContentValues;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;JJ)V

    .line 3542
    const-string v0, "conversations"

    const/4 v2, 0x0

    invoke-virtual {v11, v0, v2, v1}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v9

    .line 3543
    invoke-virtual {v11}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 3545
    :try_start_2
    invoke-virtual {p0, v11}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 3547
    const-wide/16 v2, 0x0

    cmp-long v0, v9, v2

    if-lez v0, :cond_0

    .line 3548
    invoke-virtual {p0, v9, v10, p1}, Lco/vine/android/provider/VineDatabaseHelper;->mergeConversationRecipients(JLjava/util/Collection;)V

    .line 3549
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v2, Lco/vine/android/provider/Vine$InboxView;->CONTENT_URI:Landroid/net/Uri;

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 3552
    :cond_0
    monitor-exit p0

    return-wide v9

    .line 3545
    .end local v1    # "values":Landroid/content/ContentValues;
    :catchall_0
    move-exception v0

    :try_start_3
    invoke-virtual {p0, v11}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 3535
    .end local v9    # "conversationRowId":J
    .end local v11    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public createNewUserFromNonUserIdRecipientInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)J
    .locals 38
    .param p1, "display"    # Ljava/lang/String;
    .param p2, "phone"    # Ljava/lang/String;
    .param p3, "email"    # Ljava/lang/String;

    .prologue
    .line 3506
    new-instance v2, Lco/vine/android/api/VineUser;

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const-wide/16 v7, -0x1

    const-wide/16 v9, -0x1

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    const/16 v22, 0x0

    const/16 v23, 0x0

    const/16 v24, 0x0

    const/16 v25, 0x0

    const/16 v26, 0x0

    const/16 v27, 0x0

    const/16 v28, 0x0

    const/16 v29, 0x0

    const-string v30, ""

    const/16 v31, 0x0

    const/16 v32, 0x0

    const/16 v33, 0x0

    const-wide/16 v34, 0x0

    move-object/from16 v3, p1

    move-object/from16 v20, p3

    move-object/from16 v21, p2

    invoke-direct/range {v2 .. v35}, Lco/vine/android/api/VineUser;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJIIIIIIIIILjava/lang/String;Ljava/lang/String;IIIILjava/lang/String;ZIILjava/lang/String;ZZZJ)V

    .line 3508
    .local v2, "user":Lco/vine/android/api/VineUser;
    new-instance v37, Landroid/content/ContentValues;

    invoke-direct/range {v37 .. v37}, Landroid/content/ContentValues;-><init>()V

    .line 3509
    .local v37, "values":Landroid/content/ContentValues;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    move-object/from16 v0, p0

    move-object/from16 v1, v37

    invoke-direct {v0, v1, v2, v3, v4}, Lco/vine/android/provider/VineDatabaseHelper;->fillUserContentValues(Landroid/content/ContentValues;Lco/vine/android/api/VineUser;J)V

    .line 3510
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v36

    .line 3511
    .local v36, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v3, "users"

    const-string v4, "last_refresh"

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v0, v3, v4, v1}, Landroid/database/sqlite/SQLiteDatabase;->insertOrThrow(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v3

    return-wide v3
.end method

.method public createPreMergeConversationIdAndRecipientsIfNecessary(Ljava/util/List;I)J
    .locals 9
    .param p2, "networkType"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lco/vine/android/api/VineRecipient;",
            ">;I)J"
        }
    .end annotation

    .prologue
    .line 3479
    .local p1, "recipients":Ljava/util/List;, "Ljava/util/List<Lco/vine/android/api/VineRecipient;>;"
    new-instance v6, Ljava/util/HashSet;

    invoke-direct {v6}, Ljava/util/HashSet;-><init>()V

    .line 3480
    .local v6, "userRowIds":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/Long;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/api/VineRecipient;

    .line 3482
    .local v3, "recipient":Lco/vine/android/api/VineRecipient;
    invoke-virtual {v3}, Lco/vine/android/api/VineRecipient;->isFromUser()Z

    move-result v7

    if-nez v7, :cond_2

    .line 3483
    invoke-virtual {p0, v3}, Lco/vine/android/provider/VineDatabaseHelper;->getUserRowIdForRecipient(Lco/vine/android/api/VineRecipient;)J

    move-result-wide v4

    .line 3484
    .local v4, "recipientId":J
    const-wide/16 v7, 0x0

    cmp-long v7, v4, v7

    if-gtz v7, :cond_0

    .line 3485
    const/4 v0, 0x0

    .line 3486
    .local v0, "email":Ljava/lang/String;
    const/4 v2, 0x0

    .line 3487
    .local v2, "phone":Ljava/lang/String;
    invoke-virtual {v3}, Lco/vine/android/api/VineRecipient;->isFromEmail()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 3488
    iget-object v0, v3, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    .line 3492
    :goto_1
    iget-object v7, v3, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    invoke-virtual {p0, v7, v2, v0}, Lco/vine/android/provider/VineDatabaseHelper;->createNewUserFromNonUserIdRecipientInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)J

    move-result-wide v4

    .line 3495
    .end local v0    # "email":Ljava/lang/String;
    .end local v2    # "phone":Ljava/lang/String;
    :cond_0
    iput-wide v4, v3, Lco/vine/android/api/VineRecipient;->recipientId:J

    .line 3496
    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 3490
    .restart local v0    # "email":Ljava/lang/String;
    .restart local v2    # "phone":Ljava/lang/String;
    :cond_1
    iget-object v2, v3, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    goto :goto_1

    .line 3498
    .end local v0    # "email":Ljava/lang/String;
    .end local v2    # "phone":Ljava/lang/String;
    .end local v4    # "recipientId":J
    :cond_2
    iget-wide v7, v3, Lco/vine/android/api/VineRecipient;->recipientId:J

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 3502
    .end local v3    # "recipient":Lco/vine/android/api/VineRecipient;
    :cond_3
    invoke-virtual {p0, v6, p2}, Lco/vine/android/provider/VineDatabaseHelper;->createConversationRowId(Ljava/util/HashSet;I)J

    move-result-wide v7

    return-wide v7
.end method

.method protected createTables(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 146
    const-string v0, "CREATE TABLE  users (_id INTEGER PRIMARY KEY,user_id INT,avatar_url TEXT,blocked INT,blocking INT,hide_profile_reposts INT,description TEXT,location TEXT,explicit INT,follower_count INT,following_count INT,following_flag INT,like_count INT,post_count INT,username TEXT,email_address TEXT,phone_number TEXT,verified INT,follow_status INT,last_refresh INT,accepts_oon_conversations INT,profile_background INT, loop_count INT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 147
    const-string v0, "CREATE TABLE  settings (_id INTEGER PRIMARY KEY,name TEXT UNIQUE ON CONFLICT REPLACE,value TEXT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 148
    const-string v0, "CREATE TABLE  user_sections (_id INTEGER PRIMARY KEY,user_id INT, section_type INT, section_index INT, section_title TEXT, last_section_refresh INT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 149
    const-string v0, "CREATE TABLE  user_groups (_id INTEGER PRIMARY KEY,type INT,tag TEXT,user_id INT,is_last INT,g_flags INT,order_id INT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 150
    const-string v0, "CREATE TABLE  comments (_id INTEGER PRIMARY KEY,comment_id INT UNIQUE NOT NULL,post_id INT NOT NULL,avatar_url TEXT,comment TEXT,user_id INT,username TEXT,timestamp INT,location TEXT,verified INT,entities BLOB,is_last INT,last_refresh INT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 151
    const-string v0, "CREATE VIEW  user_groups_view AS SELECT user_groups._id AS _id,user_groups.type AS type,user_groups.tag AS tag,user_groups.user_id AS user_id,user_groups.is_last AS is_last,user_groups.g_flags AS g_flags,user_groups.order_id AS order_id,user.username AS username,user.user_id AS user_id,user.avatar_url AS avatar_url,user.blocked AS blocked,user.blocking AS blocking,user.description AS description,user.location AS location,user.explicit AS explicit,user.follower_count AS follower_count,user.following_count AS following_count,user.following_flag AS following_flag,user.like_count AS like_count,user.post_count AS post_count,user.follow_status AS follow_status,user.verified AS verified,user.accepts_oon_conversations AS accepts_oon_conversations,user.profile_background AS profile_background, user.loop_count AS loop_count, section.last_section_refresh AS last_section_refresh,section.section_index AS section_index,section.section_title AS section_title,section.section_type AS section_type FROM user_groups LEFT JOIN users AS user ON user_groups.user_id=user.user_id LEFT JOIN user_sections as section ON section.user_id=user.user_id ;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 152
    const-string v0, "CREATE TABLE  likes (_id INTEGER PRIMARY KEY,like_id INT UNIQUE NOT NULL,post_id INT NOT NULL,avatar_url TEXT,user_id INT,username TEXT,timestamp INT,location TEXT,verified INT,last_refresh INT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 153
    const-string v0, "CREATE TABLE  posts (_id INTEGER PRIMARY KEY,post_id INT NOT NULL,my_repost_id INT,tags BLOB,thumbnail_url TEXT,share_url TEXT,video_low_uRL TEXT,video_url TEXT,description TEXT,foursquare_venue_id TEXT,metadata_flags INT,post_flags INT,avatar_url TEXT,user_id INT,username TEXT,timestamp INT,location TEXT,venue_data BLOB,entities BLOB,likes_count INT,reviners_count INT,comments_count INT,user_background_color INT,last_refresh INT,loops INT,velocity INT,on_fire INT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 154
    const-string v0, "CREATE TABLE  post_groups (_id INTEGER PRIMARY KEY,post_type INT,tag TEXT,post_id INT,is_last INT,repost_data BLOB,reposter_id INT,sort_id INT,g_flags INT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 155
    const-string v0, "CREATE VIEW  post_groups_view AS SELECT post_groups._id AS _id,post_groups.post_type AS post_type,post_groups.tag AS tag,post_groups.post_id AS post_id,post_groups.is_last AS is_last,post_groups.g_flags AS g_flags,post_groups.sort_id AS sort_id,post_groups.repost_data AS repost_data,post_groups.reposter_id AS reposter_id,posts.username AS username,posts.avatar_url AS avatar_url,posts.thumbnail_url AS thumbnail_url,posts.metadata_flags AS metadata_flags,posts.user_id AS user_id,posts.my_repost_id AS my_repost_id,posts.timestamp AS timestamp,posts.location AS location,posts.tags AS tags,posts.share_url AS share_url,posts.video_low_uRL AS video_low_uRL,posts.video_url AS video_url,posts.video_low_uRL AS video_low_uRL,posts.description AS description,posts.foursquare_venue_id AS foursquare_venue_id,posts.post_flags AS post_flags,posts.venue_data AS venue_data,posts.entities AS entities,posts.likes_count AS likes_count,posts.reviners_count AS reviners_count,posts.comments_count AS comments_count,posts.user_background_color AS user_background_color,posts.loops AS loops,posts.velocity AS velocity,posts.on_fire AS on_fire,posts.last_refresh AS last_refresh FROM post_groups LEFT JOIN posts AS posts ON post_groups.post_id=posts.post_id;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 156
    const-string v0, "CREATE VIEW  post_comments_likes_view AS  SELECT post_groups_view._id AS _id,post_groups_view.post_id AS post_id,post_groups_view.my_repost_id AS my_repost_id,post_groups_view.tags AS tags,post_groups_view.thumbnail_url AS thumbnail_url,post_groups_view.share_url AS share_url,post_groups_view.video_low_uRL AS video_low_uRL,post_groups_view.video_url AS video_url,post_groups_view.description AS description,post_groups_view.foursquare_venue_id AS foursquare_venue_id,post_groups_view.metadata_flags AS metadata_flags,post_groups_view.post_flags AS post_flags,post_groups_view.post_type AS post_type,post_groups_view.tag AS tag,post_groups_view.sort_id AS sort_id,post_groups_view.is_last AS is_last,post_groups_view.avatar_url AS avatar_url,post_groups_view.user_id AS user_id,post_groups_view.timestamp AS timestamp,post_groups_view.location AS location,post_groups_view.username AS username,post_groups_view.venue_data AS venue_data,post_groups_view.entities AS entities,post_groups_view.repost_data AS repost_data,post_groups_view.reposter_id AS reposter_id,post_groups_view.likes_count AS likes_count,post_groups_view.reviners_count AS reviners_count,post_groups_view.comments_count AS comments_count,post_groups_view.user_background_color AS user_background_color,post_groups_view.loops AS loops,post_groups_view.velocity AS velocity,post_groups_view.on_fire AS on_fire,post_groups_view.last_refresh AS last_refresh,likes.like_id AS like_id,likes.avatar_url AS like_user_avatar_url,likes.user_id AS like_user_user_id,likes.timestamp AS like_user_timestamp,likes.location AS like_user_location,likes.username AS like_user_username,likes.verified AS like_user_verified,null  AS comment_id,null  AS comment,null  AS comment_user_avatar_url,null  AS comment_user_user_id,null  AS comment_user_timestamp,null  AS comment_user_location,null  AS comment_user_username,null  AS comment_user_verified,null  AS comment_is_last,null  AS comment_entities FROM post_groups_view LEFT JOIN likes ON post_groups_view.post_id = likes.post_id UNION SELECT post_groups_view._id AS _id,post_groups_view.post_id AS post_id,post_groups_view.my_repost_id AS my_repost_id,post_groups_view.tags AS tags,post_groups_view.thumbnail_url AS thumbnail_url,post_groups_view.share_url AS share_url,post_groups_view.video_low_uRL AS video_low_uRL,post_groups_view.video_url AS video_url,post_groups_view.description AS description,post_groups_view.foursquare_venue_id AS foursquare_venue_id,post_groups_view.metadata_flags AS metadata_flags,post_groups_view.post_flags AS post_flags,post_groups_view.post_type AS post_type,post_groups_view.tag AS tag,post_groups_view.sort_id AS sort_id,post_groups_view.is_last AS is_last,post_groups_view.avatar_url AS avatar_url,post_groups_view.user_id AS user_id,post_groups_view.timestamp AS timestamp,post_groups_view.location AS location,post_groups_view.username AS username,post_groups_view.venue_data AS venue_data,post_groups_view.entities AS entities,post_groups_view.repost_data AS repost_data,post_groups_view.reposter_id AS reposter_id,post_groups_view.likes_count AS likes_count,post_groups_view.reviners_count AS reviners_count,post_groups_view.comments_count AS comments_count,post_groups_view.user_background_color AS user_background_color,post_groups_view.loops AS loops,post_groups_view.velocity AS velocity,post_groups_view.on_fire AS on_fire,post_groups_view.last_refresh AS last_refresh,null  AS like_id,null  AS like_user_avatar_url,null  AS like_user_user_id,null  AS like_user_timestamp,null  AS like_user_location,null  AS like_user_username,null  AS like_user_verified,comments.comment_id AS comment_id,comments.comment AS comment,comments.avatar_url AS comment_user_avatar_url,comments.user_id AS comment_user_user_id,comments.timestamp AS comment_user_timestamp,comments.location AS comment_user_location,comments.username AS comment_user_username,comments.verified AS comment_user_verified,comments.is_last AS comment_is_last,comments.entities AS comment_entities FROM post_groups_view LEFT JOIN comments ON post_groups_view.post_id = comments.post_id "

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 157
    const-string v0, "CREATE TABLE  page_cursors (_id INTEGER PRIMARY KEY,type INT,tag TEXT,kind INT,next_page INT,previous_page INT,anchor TEXT,reversed INT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 158
    const-string v0, "CREATE TABLE  tag_search_results (_id INTEGER PRIMARY KEY,tag_id INT UNIQUE NOT NULL,tag_name TEXT NOT NULL,last_used_timestamp TEXT,is_last INT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 159
    const-string v0, "CREATE TABLE  channels (_id INTEGER PRIMARY KEY,channel_id INT UNIQUE NOT NULL,channel TEXT NOT NULL,timestamp INT,background_color TEXT,font_color TEXT,last_used_timestamp INT,is_last INT,icon_full_url TEXT,retina_icon_full_url TEXT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 160
    const-string v0, "CREATE TABLE  notifications (_id INTEGER PRIMARY KEY,notification_id INT UNIQUE NOT NULL,notification_type INT,message TEXT,cleared INT, conversation_row_id INT, avatar_url TEXT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 161
    const-string v0, "CREATE TABLE  tag_recently_used (_id INTEGER PRIMARY KEY,tag_id INT UNIQUE NOT NULL,tag_name TEXT NOT NULL,last_used_timestamp TEXT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 162
    const-string v0, "CREATE TABLE  editions (_id INTEGER PRIMARY KEY,edition_code TEXT,edition_name TEXT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 163
    const-string v0, "CREATE TABLE  messages (_id INTEGER PRIMARY KEY,conversation_row_id INT NOT NULL,message_id INT NOT NULL,user_row_id INT NOT NULL,timestamp INT,message TEXT,video_url TEXT,thumbnail_url TEXT, is_last INT,vanished INT,max_loops INT,vanished_date INT,ephemeral INT,local_start_time INT,deleted INT,post_id INT,upload_path TEXT,error_code INT,error_reason TEXT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 164
    const-string v0, "CREATE TABLE  conversations (_id INTEGER PRIMARY KEY,conversation_id INT NOT NULL,network_type INT NOT NULL, unread_message_count INT, is_hidden INT DEFAULT 0, last_message INT, last_message_timestamp INT, is_last INT);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 165
    const-string v0, "CREATE VIEW message_users_view AS SELECT m._id AS _id,m.conversation_row_id AS conversation_row_id,m.message_id AS message_id,m.user_row_id AS user_row_id,m.message AS message,m.timestamp AS timestamp,m.video_url AS video_url,m.thumbnail_url AS thumbnail_url,m.is_last AS is_last,m.vanished AS vanished,m.max_loops AS max_loops,m.vanished_date AS vanished_date,m.ephemeral AS ephemeral,m.local_start_time AS local_start_time,m.deleted AS deleted,m.post_id AS post_id,m.upload_path AS upload_path,m.error_code AS error_code,m.error_reason AS error_reason,c.conversation_id AS conversation_id,c.network_type AS network_type,c.is_hidden AS is_hidden,c.unread_message_count AS unread_message_count,user.username AS sender_user_name,user.avatar_url AS sender_avatar,user.profile_background AS sender_profile_background,post.user_id AS author_user_id,post.username AS author_user_name,post.avatar_url AS author_avatar,post.entities AS post_entities,post.description AS post_description,post.share_url AS post_share_url FROM messages AS  m LEFT JOIN users AS user ON m.user_row_id=user._id LEFT JOIN conversations AS c ON m.conversation_row_id=c._id LEFT JOIN (SELECT p.post_id, p.user_id, p.username, p.avatar_url, p.entities, p.description, p.share_url FROM messages AS m LEFT JOIN post_comments_likes_view AS p ON m.post_id=p.post_id GROUP BY p.post_id) AS post ON m.post_id=post.post_id;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 166
    const-string v0, "CREATE TABLE conversation_recipients (_id INTEGER PRIMARY KEY,conversation_row_id INT NOT NULL,user_row_id INT NOT NULL, UNIQUE (conversation_row_id,user_row_id) ON CONFLICT IGNORE);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 167
    const-string v0, "CREATE VIEW inbox_view AS SELECT cr._id AS _id,cr.conversation_row_id AS conversation_row_id,( SELECT COUNT(*) FROM conversation_recipients where conversation_row_id = cr.conversation_row_id group by conversation_row_id) AS recipients_count,m.timestamp AS timestamp,m.error_reason AS error_reason,c.network_type AS network_type,c.unread_message_count AS unread_message_count,c.is_hidden AS is_hidden,c.last_message AS last_message,c.is_last AS is_last,u.username AS username,u._id AS user_row_id,u.user_id AS user_id,u.following_flag AS following_flag,u.avatar_url AS avatar_url,u.profile_background AS profile_background FROM conversation_recipients AS cr JOIN users AS u ON cr.user_row_id= u._id JOIN messages AS m ON c.last_message=m._id JOIN conversations AS c ON c._id =cr.conversation_row_id GROUP BY cr.conversation_row_id ORDER BY timestamp DESC;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 168
    const-string v0, "CREATE VIEW  conversation_recipients_users_view AS SELECT conversation_recipients._id AS _id,conversation_recipients.conversation_row_id AS conversation_row_id,conversation_recipients.user_row_id AS user_row_id,user.username AS username,user.user_id AS user_id,user.phone_number AS phone_number,user.email_address AS email_address,user.profile_background AS profile_background FROM conversation_recipients LEFT JOIN users AS user ON conversation_recipients.user_row_id=user._id;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 169
    return-void
.end method

.method public declared-synchronized deleteComment(Ljava/lang/String;)I
    .locals 6
    .param p1, "commentId"    # Ljava/lang/String;

    .prologue
    .line 713
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 714
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v2, "comments"

    const-string v3, "comment_id=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    invoke-virtual {v0, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 718
    .local v1, "deleted":I
    if-lez v1, :cond_0

    .line 719
    iget-object v2, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v3, Lco/vine/android/provider/Vine$Comments;->CONTENT_URI:Landroid/net/Uri;

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 720
    invoke-direct {p0}, Lco/vine/android/provider/VineDatabaseHelper;->notifyPostCommentsViewUris()V

    .line 723
    :cond_0
    sget-boolean v2, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v2, :cond_1

    .line 724
    if-lez v1, :cond_2

    .line 725
    const-string v2, "VineDH"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Deleting comment: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 730
    :cond_1
    :goto_0
    monitor-exit p0

    return v1

    .line 727
    :cond_2
    :try_start_1
    const-string v2, "VineDH"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Couldn\'t delete comment: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 713
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "deleted":I
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized deleteConversation(JJ)V
    .locals 9
    .param p1, "conversationId"    # J
    .param p3, "conversationRowId"    # J

    .prologue
    const-wide/16 v7, 0x0

    .line 2358
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v0

    .line 2359
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v1, 0x0

    .line 2361
    .local v1, "deleted":I
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 2362
    cmp-long v2, p1, v7

    if-lez v2, :cond_0

    .line 2363
    const-string v2, "conversations"

    const-string v3, "conversation_id=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v0, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 2368
    :cond_0
    cmp-long v2, p3, v7

    if-lez v2, :cond_1

    .line 2369
    const-string v2, "conversations"

    const-string v3, "_id=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p3, p4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v0, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    add-int/2addr v1, v2

    .line 2373
    const-string v2, "messages"

    const-string v3, "conversation_row_id=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p3, p4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v0, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    add-int/2addr v1, v2

    .line 2376
    const-string v2, "conversation_recipients"

    const-string v3, "conversation_row_id=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p3, p4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v0, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    add-int/2addr v1, v2

    .line 2381
    :cond_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2383
    :try_start_2
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 2386
    sget-boolean v2, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v2, :cond_2

    .line 2387
    const-string v2, "VineDH"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Deleted conversation "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 2390
    :cond_2
    if-lez v1, :cond_3

    .line 2391
    invoke-direct {p0}, Lco/vine/android/provider/VineDatabaseHelper;->notifyVMUris()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2393
    :cond_3
    monitor-exit p0

    return-void

    .line 2383
    :catchall_0
    move-exception v2

    :try_start_3
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 2358
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "deleted":I
    :catchall_1
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized deleteMessage(J)V
    .locals 15
    .param p1, "messageId"    # J

    .prologue
    .line 3405
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3407
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v14, Landroid/content/ContentValues;

    invoke-direct {v14}, Landroid/content/ContentValues;-><init>()V

    .line 3408
    .local v14, "values":Landroid/content/ContentValues;
    const-string v1, "deleted"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v14, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3410
    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v12

    .line 3411
    .local v12, "messageIdString":Ljava/lang/String;
    const-string v1, "messages"

    const-string v2, "message_id=?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object v12, v3, v4

    invoke-virtual {v0, v1, v14, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v13

    .line 3413
    .local v13, "updated":I
    const-string v1, "messages"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "conversation_row_id"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string v4, "is_last"

    aput-object v4, v2, v3

    const-string v3, "message_id=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object v12, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v8

    .line 3415
    .local v8, "c":Landroid/database/Cursor;
    if-eqz v8, :cond_1

    .line 3417
    :try_start_1
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 3418
    const/4 v1, 0x0

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v9

    .line 3419
    .local v9, "conversationRowId":J
    const/4 v1, 0x1

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_3

    const/4 v11, 0x1

    .line 3420
    .local v11, "isLast":Z
    :goto_0
    invoke-virtual {p0, v9, v10, v0}, Lco/vine/android/provider/VineDatabaseHelper;->getNumberVisibleMessagesInConversation(JLandroid/database/sqlite/SQLiteDatabase;)I

    move-result v1

    if-nez v1, :cond_4

    .line 3421
    const/4 v1, 0x1

    invoke-virtual {p0, v9, v10, v1}, Lco/vine/android/provider/VineDatabaseHelper;->setConversationHidden(JZ)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 3427
    .end local v9    # "conversationRowId":J
    .end local v11    # "isLast":Z
    :cond_0
    :goto_1
    :try_start_2
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 3431
    :cond_1
    if-lez v13, :cond_2

    .line 3432
    invoke-direct {p0}, Lco/vine/android/provider/VineDatabaseHelper;->notifyVMUris()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 3434
    :cond_2
    monitor-exit p0

    return-void

    .line 3419
    .restart local v9    # "conversationRowId":J
    :cond_3
    const/4 v11, 0x0

    goto :goto_0

    .line 3422
    .restart local v11    # "isLast":Z
    :cond_4
    if-eqz v11, :cond_0

    .line 3423
    :try_start_3
    invoke-virtual {p0, v9, v10}, Lco/vine/android/provider/VineDatabaseHelper;->markLastMessage(J)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1

    .line 3427
    .end local v9    # "conversationRowId":J
    .end local v11    # "isLast":Z
    :catchall_0
    move-exception v1

    :try_start_4
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 3405
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v8    # "c":Landroid/database/Cursor;
    .end local v12    # "messageIdString":Ljava/lang/String;
    .end local v13    # "updated":I
    .end local v14    # "values":Landroid/content/ContentValues;
    :catchall_1
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized deletePost(J)I
    .locals 8
    .param p1, "postId"    # J

    .prologue
    .line 1296
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v0

    .line 1299
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 1300
    const-string v3, "posts"

    const-string v4, "post_id=?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v0, v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 1302
    .local v1, "deleted":I
    const/4 v2, 0x0

    .line 1303
    .local v2, "deletedGroups":I
    if-lez v1, :cond_0

    .line 1304
    const-string v3, "post_groups"

    const-string v4, "post_id=?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v0, v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    .line 1307
    :cond_0
    if-gtz v1, :cond_1

    if-lez v2, :cond_2

    .line 1308
    :cond_1
    invoke-direct {p0}, Lco/vine/android/provider/VineDatabaseHelper;->notifyPostCommentsViewUris()V

    .line 1311
    :cond_2
    sget-boolean v3, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v3, :cond_3

    .line 1312
    if-lez v2, :cond_4

    .line 1313
    const-string v3, "VineDH"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Removing the post: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1318
    :cond_3
    :goto_0
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1320
    :try_start_2
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 1322
    monitor-exit p0

    return v1

    .line 1315
    :cond_4
    :try_start_3
    const-string v3, "VineDH"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Couldn\'t delete post: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 1320
    .end local v1    # "deleted":I
    .end local v2    # "deletedGroups":I
    :catchall_0
    move-exception v3

    :try_start_4
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v3
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 1296
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :catchall_1
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public declared-synchronized deletePushNotifications(I)I
    .locals 7
    .param p1, "notificationDisplayId"    # I

    .prologue
    const/4 v2, 0x1

    const/4 v5, 0x0

    .line 1154
    monitor-enter p0

    const/4 v6, 0x2

    if-ne p1, v6, :cond_0

    .line 1156
    .local v2, "isPrivateMessage":Z
    :goto_0
    :try_start_0
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "notification_type"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    if-eqz v2, :cond_1

    const-string v5, "=?"

    :goto_1
    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 1157
    .local v3, "selection":Ljava/lang/String;
    const/4 v5, 0x1

    new-array v4, v5, [Ljava/lang/String;

    const/4 v5, 0x0

    const/16 v6, 0x12

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    .line 1159
    .local v4, "whereArgs":[Ljava/lang/String;
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v0

    .line 1160
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v1, 0x0

    .line 1163
    .local v1, "deleted":I
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 1164
    const-string v5, "notifications"

    invoke-virtual {v0, v5, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v5

    add-int/2addr v1, v5

    .line 1165
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1167
    :try_start_2
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 1170
    monitor-exit p0

    return v1

    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "deleted":I
    .end local v2    # "isPrivateMessage":Z
    .end local v3    # "selection":Ljava/lang/String;
    .end local v4    # "whereArgs":[Ljava/lang/String;
    :cond_0
    move v2, v5

    .line 1154
    goto :goto_0

    .line 1156
    .restart local v2    # "isPrivateMessage":Z
    :cond_1
    :try_start_3
    const-string v5, "<>?"

    goto :goto_1

    .line 1167
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v1    # "deleted":I
    .restart local v3    # "selection":Ljava/lang/String;
    .restart local v4    # "whereArgs":[Ljava/lang/String;
    :catchall_0
    move-exception v5

    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v5
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 1154
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "deleted":I
    .end local v3    # "selection":Ljava/lang/String;
    .end local v4    # "whereArgs":[Ljava/lang/String;
    :catchall_1
    move-exception v5

    monitor-exit p0

    throw v5
.end method

.method public determineBestConversationRowIdForRecipient(Lco/vine/android/api/VineRecipient;)J
    .locals 4
    .param p1, "recipient"    # Lco/vine/android/api/VineRecipient;

    .prologue
    .line 3762
    invoke-virtual {p0, p1}, Lco/vine/android/provider/VineDatabaseHelper;->getUserRowIdForRecipient(Lco/vine/android/api/VineRecipient;)J

    move-result-wide v0

    .line 3763
    .local v0, "userRowId":J
    invoke-virtual {p0, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->determineBestConversationRowIdForUserRowId(J)J

    move-result-wide v2

    return-wide v2
.end method

.method public determineBestConversationRowIdForUserRemoteId(J)J
    .locals 4
    .param p1, "userRemoteId"    # J

    .prologue
    .line 3767
    invoke-virtual {p0, p1, p2}, Lco/vine/android/provider/VineDatabaseHelper;->getUserRowIdForUserRemoteId(J)J

    move-result-wide v0

    .line 3768
    .local v0, "userRowId":J
    invoke-virtual {p0, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->determineBestConversationRowIdForUserRowId(J)J

    move-result-wide v2

    return-wide v2
.end method

.method public determineBestConversationRowIdForUserRowId(J)J
    .locals 14
    .param p1, "userRowId"    # J

    .prologue
    .line 3772
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3774
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "conversation_recipients"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "conversation_row_id"

    aput-object v4, v2, v3

    const-string v3, "user_row_id =?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 3779
    .local v8, "c":Landroid/database/Cursor;
    const-wide/16 v12, -0x1

    .line 3780
    .local v12, "resultConversationObjectId":J
    if-eqz v8, :cond_2

    .line 3784
    :cond_0
    :goto_0
    :try_start_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 3785
    const/4 v1, 0x0

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v10

    .line 3786
    .local v10, "conversationObjectId":J
    const-string v1, "conversation_recipients"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "_id"

    aput-object v4, v2, v3

    const-string v3, "conversation_row_id =? "

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {v10, v11}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v9

    .line 3790
    .local v9, "c2":Landroid/database/Cursor;
    if-eqz v9, :cond_0

    .line 3792
    :try_start_1
    invoke-interface {v9}, Landroid/database/Cursor;->getCount()I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_3

    .line 3793
    move-wide v12, v10

    .line 3794
    invoke-interface {v9}, Landroid/database/Cursor;->close()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 3798
    if-eqz v9, :cond_1

    .line 3799
    :try_start_2
    invoke-interface {v9}, Landroid/database/Cursor;->close()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 3805
    .end local v9    # "c2":Landroid/database/Cursor;
    .end local v10    # "conversationObjectId":J
    :cond_1
    if-eqz v8, :cond_2

    .line 3806
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 3810
    :cond_2
    return-wide v12

    .line 3798
    .restart local v9    # "c2":Landroid/database/Cursor;
    .restart local v10    # "conversationObjectId":J
    :cond_3
    if-eqz v9, :cond_0

    .line 3799
    :try_start_3
    invoke-interface {v9}, Landroid/database/Cursor;->close()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 3805
    .end local v9    # "c2":Landroid/database/Cursor;
    .end local v10    # "conversationObjectId":J
    :catchall_0
    move-exception v1

    if-eqz v8, :cond_4

    .line 3806
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    :cond_4
    throw v1

    .line 3798
    .restart local v9    # "c2":Landroid/database/Cursor;
    .restart local v10    # "conversationObjectId":J
    :catchall_1
    move-exception v1

    if-eqz v9, :cond_5

    .line 3799
    :try_start_4
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    :cond_5
    throw v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0
.end method

.method public determineOrCreateBestConversationRowIdForRecipients(Ljava/util/List;I)J
    .locals 5
    .param p2, "networkType"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lco/vine/android/api/VineRecipient;",
            ">;I)J"
        }
    .end annotation

    .prologue
    .line 3746
    .local p1, "recipients":Ljava/util/List;, "Ljava/util/List<Lco/vine/android/api/VineRecipient;>;"
    const-wide/16 v0, -0x1

    .line 3747
    .local v0, "conversationRowId":J
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 3748
    const/4 v3, 0x0

    invoke-interface {p1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/api/VineRecipient;

    .line 3749
    .local v2, "recipient":Lco/vine/android/api/VineRecipient;
    invoke-virtual {p0, v2}, Lco/vine/android/provider/VineDatabaseHelper;->determineBestConversationRowIdForRecipient(Lco/vine/android/api/VineRecipient;)J

    move-result-wide v0

    .line 3753
    .end local v2    # "recipient":Lco/vine/android/api/VineRecipient;
    :cond_0
    const-wide/16 v3, 0x0

    cmp-long v3, v0, v3

    if-gtz v3, :cond_1

    .line 3754
    invoke-virtual {p0, p1, p2}, Lco/vine/android/provider/VineDatabaseHelper;->createPreMergeConversationIdAndRecipientsIfNecessary(Ljava/util/List;I)J

    move-result-wide v0

    .line 3756
    :cond_1
    return-wide v0
.end method

.method public declared-synchronized expireTimeline(I)V
    .locals 1
    .param p1, "type"    # I

    .prologue
    .line 1326
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1}, Lco/vine/android/provider/VineDatabaseHelper;->removePostsFromGroup(I)I

    .line 1327
    invoke-direct {p0}, Lco/vine/android/provider/VineDatabaseHelper;->notifyPostCommentsViewUris()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1328
    monitor-exit p0

    return-void

    .line 1326
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getCommentsCount(J)I
    .locals 10
    .param p1, "postId"    # J

    .prologue
    const/4 v9, 0x0

    .line 734
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 736
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "comments"

    sget-object v2, Lco/vine/android/provider/VineDatabaseSQL$CommentsQuery;->PROJECTION:[Ljava/lang/String;

    const-string v3, "post_id=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v8

    .line 738
    .local v8, "c":Landroid/database/Cursor;
    if-eqz v8, :cond_0

    .line 740
    :try_start_1
    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v9

    .line 743
    .local v9, "count":I
    :try_start_2
    invoke-interface {v8}, Landroid/database/Cursor;->close()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 746
    .end local v9    # "count":I
    :cond_0
    monitor-exit p0

    return v9

    .line 743
    :catchall_0
    move-exception v1

    :try_start_3
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 734
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v8    # "c":Landroid/database/Cursor;
    :catchall_1
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public getConversationNetworkType(J)I
    .locals 13
    .param p1, "conversationRowId"    # J

    .prologue
    const/4 v5, 0x0

    const/4 v10, 0x1

    const/4 v12, 0x0

    .line 1990
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 1991
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v11, "_id =? "

    .line 1992
    .local v11, "selectionString":Ljava/lang/String;
    new-array v4, v10, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v12

    .line 1993
    .local v4, "selectionArgs":[Ljava/lang/String;
    new-array v2, v10, [Ljava/lang/String;

    const-string v1, "network_type"

    aput-object v1, v2, v12

    .line 1994
    .local v2, "projection":[Ljava/lang/String;
    const-string v1, "conversations"

    const-string v3, "_id =? "

    const-string v8, "1"

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 1997
    .local v9, "c":Landroid/database/Cursor;
    if-eqz v9, :cond_0

    .line 1998
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1999
    invoke-interface {v9, v12}, Landroid/database/Cursor;->getInt(I)I

    move-result v10

    .line 2000
    .local v10, "result":I
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 2005
    .end local v10    # "result":I
    :cond_0
    :goto_0
    return v10

    .line 2003
    :cond_1
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    goto :goto_0
.end method

.method public getConversationRecipientsFromConversationRowId(J)Ljava/util/ArrayList;
    .locals 14
    .param p1, "conversationRowId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J)",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRecipient;",
            ">;"
        }
    .end annotation

    .prologue
    .line 3814
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3816
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "conversation_recipients"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "user_row_id"

    aput-object v4, v2, v3

    const-string v3, "conversation_row_id =? "

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 3820
    .local v8, "c":Landroid/database/Cursor;
    const/4 v10, 0x0

    .line 3821
    .local v10, "result":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    if-eqz v8, :cond_3

    .line 3823
    :try_start_0
    new-instance v11, Ljava/util/ArrayList;

    invoke-direct {v11}, Ljava/util/ArrayList;-><init>()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    .line 3824
    .end local v10    # "result":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    .local v11, "result":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    :cond_0
    :goto_0
    :try_start_1
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 3826
    const/4 v1, 0x0

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v12

    .line 3827
    .local v12, "userRowId":J
    const-string v1, "users"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "user_id"

    aput-object v4, v2, v3

    const-string v3, "_id=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {v12, v13}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v9

    .line 3830
    .local v9, "c2":Landroid/database/Cursor;
    if-eqz v9, :cond_0

    .line 3832
    :try_start_2
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 3833
    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-interface {v9, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    const/4 v4, 0x0

    move-wide v5, v12

    invoke-static/range {v1 .. v6}, Lco/vine/android/api/VineRecipient;->fromUser(Ljava/lang/String;JIJ)Lco/vine/android/api/VineRecipient;

    move-result-object v1

    invoke-virtual {v11, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 3836
    :cond_1
    :try_start_3
    invoke-interface {v9}, Landroid/database/Cursor;->close()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 3841
    .end local v9    # "c2":Landroid/database/Cursor;
    .end local v12    # "userRowId":J
    :catchall_0
    move-exception v1

    move-object v10, v11

    .end local v11    # "result":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    .restart local v10    # "result":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    :goto_1
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v1

    .line 3836
    .end local v10    # "result":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    .restart local v9    # "c2":Landroid/database/Cursor;
    .restart local v11    # "result":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    .restart local v12    # "userRowId":J
    :catchall_1
    move-exception v1

    :try_start_4
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    throw v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 3841
    .end local v9    # "c2":Landroid/database/Cursor;
    .end local v12    # "userRowId":J
    :cond_2
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    move-object v10, v11

    .line 3844
    .end local v11    # "result":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    .restart local v10    # "result":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    :cond_3
    return-object v10

    .line 3841
    :catchall_2
    move-exception v1

    goto :goto_1
.end method

.method public declared-synchronized getConversationRemoteId(J)J
    .locals 12
    .param p1, "conversationRowId"    # J

    .prologue
    .line 3338
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3339
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "conversations"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "conversation_id"

    aput-object v4, v2, v3

    const-string v3, "_id =?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "1"

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 3341
    .local v9, "c":Landroid/database/Cursor;
    if-eqz v9, :cond_1

    .line 3342
    const-wide/16 v10, -0x1

    .line 3343
    .local v10, "id":J
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 3344
    const/4 v1, 0x0

    invoke-interface {v9, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v10

    .line 3346
    :cond_0
    invoke-interface {v9}, Landroid/database/Cursor;->close()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 3349
    .end local v10    # "id":J
    :goto_0
    monitor-exit p0

    return-wide v10

    :cond_1
    const-wide/16 v10, -0x1

    goto :goto_0

    .line 3338
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v9    # "c":Landroid/database/Cursor;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getConversationRowId(J)J
    .locals 12
    .param p1, "conversationRemoteId"    # J

    .prologue
    .line 3353
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3354
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "conversations"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "_id"

    aput-object v4, v2, v3

    const-string v3, "conversation_id =?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "1"

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 3356
    .local v9, "c":Landroid/database/Cursor;
    if-eqz v9, :cond_1

    .line 3357
    const-wide/16 v10, -0x1

    .line 3358
    .local v10, "id":J
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 3359
    const/4 v1, 0x0

    invoke-interface {v9, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v10

    .line 3361
    :cond_0
    invoke-interface {v9}, Landroid/database/Cursor;->close()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 3364
    .end local v10    # "id":J
    :goto_0
    monitor-exit p0

    return-wide v10

    :cond_1
    const-wide/16 v10, -0x1

    goto :goto_0

    .line 3353
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v9    # "c":Landroid/database/Cursor;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public getDisplayForUser(J)Ljava/lang/String;
    .locals 10
    .param p1, "recipientId"    # J

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    const/4 v7, 0x0

    .line 3917
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3918
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "users"

    new-array v2, v4, [Ljava/lang/String;

    const-string v3, "username"

    aput-object v3, v2, v7

    const-string v3, "_id =? "

    new-array v4, v4, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v7

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 3920
    .local v8, "c":Landroid/database/Cursor;
    const/4 v9, 0x0

    .line 3921
    .local v9, "name":Ljava/lang/String;
    if-eqz v8, :cond_1

    .line 3923
    :try_start_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 3924
    const/4 v1, 0x0

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v9

    .line 3927
    :cond_0
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 3930
    :cond_1
    return-object v9

    .line 3927
    :catchall_0
    move-exception v1

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method public declared-synchronized getLastMessageIdInConversation(J)J
    .locals 12
    .param p1, "conversationRowId"    # J

    .prologue
    .line 3368
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3369
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "messages"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "message_id"

    aput-object v4, v2, v3

    const-string v3, "conversation_row_id =? "

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const-string v7, "message_id DESC"

    const-string v8, "1"

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 3372
    .local v9, "c":Landroid/database/Cursor;
    const-wide/16 v10, -0x1

    .line 3373
    .local v10, "ret":J
    if-eqz v9, :cond_1

    .line 3374
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 3375
    const/4 v1, 0x0

    invoke-interface {v9, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v10

    .line 3377
    :cond_0
    invoke-interface {v9}, Landroid/database/Cursor;->close()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 3379
    :cond_1
    monitor-exit p0

    return-wide v10

    .line 3368
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v9    # "c":Landroid/database/Cursor;
    .end local v10    # "ret":J
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public getMessageFromMessageRow(J)Lco/vine/android/api/VinePrivateMessage;
    .locals 11
    .param p1, "mergedMessageId"    # J

    .prologue
    .line 3556
    const/4 v9, 0x0

    .line 3557
    .local v9, "vpm":Lco/vine/android/api/VinePrivateMessage;
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3558
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v8, 0x0

    .line 3561
    .local v8, "c":Landroid/database/Cursor;
    :try_start_0
    const-string v1, "message_users_view"

    sget-object v2, Lco/vine/android/provider/VineDatabaseSQL$ConversationMessageUsersQuery;->PROJECTION:[Ljava/lang/String;

    const-string v3, "_id=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v8

    .line 3564
    if-eqz v8, :cond_1

    .line 3566
    :try_start_1
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 3567
    new-instance v10, Lco/vine/android/api/VinePrivateMessage;

    invoke-direct {v10, v8}, Lco/vine/android/api/VinePrivateMessage;-><init>(Landroid/database/Cursor;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .end local v9    # "vpm":Lco/vine/android/api/VinePrivateMessage;
    .local v10, "vpm":Lco/vine/android/api/VinePrivateMessage;
    move-object v9, v10

    .line 3570
    .end local v10    # "vpm":Lco/vine/android/api/VinePrivateMessage;
    .restart local v9    # "vpm":Lco/vine/android/api/VinePrivateMessage;
    :cond_0
    :try_start_2
    invoke-interface {v8}, Landroid/database/Cursor;->close()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 3574
    :cond_1
    if-eqz v8, :cond_2

    .line 3575
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 3578
    :cond_2
    return-object v9

    .line 3570
    :catchall_0
    move-exception v1

    :try_start_3
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 3574
    :catchall_1
    move-exception v1

    if-eqz v8, :cond_3

    .line 3575
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    :cond_3
    throw v1
.end method

.method public getMessagesForConversationRowId(J)Landroid/database/Cursor;
    .locals 8
    .param p1, "conversationRowId"    # J

    .prologue
    const/4 v5, 0x0

    .line 3941
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3942
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "message_users_view"

    sget-object v2, Lco/vine/android/provider/VineDatabaseSQL$ConversationMessageUsersQuery;->PROJECTION:[Ljava/lang/String;

    const-string v3, "conversation_row_id=? AND error_code <> 0"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v6

    const-string v7, "message_id ASC"

    move-object v6, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    return-object v1
.end method

.method public getMessagesThatWereViewed()Ljava/util/ArrayList;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 4000
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 4001
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "message_users_view"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "conversation_id"

    aput-object v3, v2, v5

    const-string v3, "message_id"

    aput-object v3, v2, v6

    const-string v3, "local_start_time"

    aput-object v3, v2, v7

    const-string v3, "local_start_time!=0"

    const-string v7, "message_id DESC"

    const-string v8, "1"

    move-object v5, v4

    move-object v6, v4

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 4005
    .local v9, "c":Landroid/database/Cursor;
    new-instance v11, Ljava/util/ArrayList;

    invoke-direct {v11}, Ljava/util/ArrayList;-><init>()V

    .line 4007
    .local v11, "messages":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;>;"
    if-eqz v9, :cond_0

    .line 4009
    :goto_0
    :try_start_0
    invoke-interface {v9}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 4010
    new-instance v1, Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;

    const/4 v2, 0x0

    invoke-interface {v9, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    const/4 v4, 0x1

    invoke-interface {v9, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    const/4 v6, 0x2

    invoke-interface {v9, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    invoke-direct/range {v1 .. v7}, Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;-><init>(JJJ)V

    invoke-virtual {v11, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 4012
    :catch_0
    move-exception v10

    .line 4013
    .local v10, "e":Ljava/lang/Exception;
    :try_start_1
    const-string v1, "Error while getting viewed messages."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 4015
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 4018
    .end local v10    # "e":Ljava/lang/Exception;
    :cond_0
    :goto_1
    return-object v11

    .line 4015
    :cond_1
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    goto :goto_1

    :catchall_0
    move-exception v1

    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method public getNewMessageId()J
    .locals 13

    .prologue
    const/4 v12, 0x0

    const/4 v3, 0x0

    .line 3878
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3879
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "messages"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const-string v4, "message_id"

    aput-object v4, v2, v12

    const-string v7, "message_id DESC"

    const-string v8, "1"

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 3880
    .local v9, "c":Landroid/database/Cursor;
    const-wide/16 v10, 0x1

    .line 3881
    .local v10, "ret":J
    if-eqz v9, :cond_1

    .line 3883
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 3884
    invoke-interface {v9, v12}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    const-wide/16 v3, 0x1

    add-long v10, v1, v3

    .line 3886
    :cond_0
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 3888
    :cond_1
    return-wide v10
.end method

.method public declared-synchronized getNextPageCursor(IILjava/lang/String;Z)I
    .locals 11
    .param p1, "kind"    # I
    .param p2, "type"    # I
    .param p3, "tag"    # Ljava/lang/String;
    .param p4, "reversed"    # Z

    .prologue
    .line 2713
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2715
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    if-eqz p4, :cond_3

    .line 2716
    const-string v9, "previous_page"

    .line 2721
    .local v9, "column":Ljava/lang/String;
    :goto_0
    if-nez p3, :cond_0

    .line 2722
    const-string p3, ""

    .line 2725
    :cond_0
    const-string v1, "page_cursors"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    aput-object v9, v2, v3

    const-string v3, "kind=? AND type=? AND tag=?"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    invoke-static {p3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v8

    .line 2729
    .local v8, "c":Landroid/database/Cursor;
    const/4 v10, -0x1

    .line 2730
    .local v10, "result":I
    if-eqz v8, :cond_2

    .line 2732
    :try_start_1
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 2733
    const/4 v1, 0x0

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getInt(I)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v10

    .line 2736
    :cond_1
    :try_start_2
    invoke-interface {v8}, Landroid/database/Cursor;->close()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2739
    :cond_2
    monitor-exit p0

    return v10

    .line 2718
    .end local v8    # "c":Landroid/database/Cursor;
    .end local v9    # "column":Ljava/lang/String;
    .end local v10    # "result":I
    :cond_3
    :try_start_3
    const-string v9, "next_page"

    .restart local v9    # "column":Ljava/lang/String;
    goto :goto_0

    .line 2736
    .restart local v8    # "c":Landroid/database/Cursor;
    .restart local v10    # "result":I
    :catchall_0
    move-exception v1

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 2713
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v8    # "c":Landroid/database/Cursor;
    .end local v9    # "column":Ljava/lang/String;
    .end local v10    # "result":I
    :catchall_1
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getNotifications(I)Ljava/util/ArrayList;
    .locals 12
    .param p1, "notificationType"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineSingleNotification;",
            ">;"
        }
    .end annotation

    .prologue
    const/16 v2, 0x12

    const/4 v10, 0x1

    const/4 v1, 0x0

    .line 1133
    monitor-enter p0

    if-ne p1, v2, :cond_0

    .line 1135
    .local v10, "isPrivateMessage":Z
    :goto_0
    :try_start_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "notification_type"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    if-eqz v10, :cond_1

    const-string v1, "=?"

    :goto_1
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 1136
    .local v3, "selection":Ljava/lang/String;
    const/4 v1, 0x1

    new-array v4, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    const/16 v2, 0x12

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v4, v1

    .line 1138
    .local v4, "whereArgs":[Ljava/lang/String;
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 1140
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v11, Ljava/util/ArrayList;

    invoke-direct {v11}, Ljava/util/ArrayList;-><init>()V

    .line 1141
    .local v11, "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    const-string v1, "notifications"

    sget-object v2, Lco/vine/android/provider/VineDatabaseSQL$NotificationsQuery;->PROJECTION:[Ljava/lang/String;

    const/4 v5, 0x0

    const/4 v6, 0x0

    const-string v7, "notification_id DESC"

    const-string v8, "10"

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 1144
    .local v9, "c":Landroid/database/Cursor;
    if-eqz v9, :cond_3

    .line 1145
    :goto_2
    invoke-interface {v9}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 1146
    new-instance v1, Lco/vine/android/api/VineSingleNotification;

    invoke-direct {v1, v9}, Lco/vine/android/api/VineSingleNotification;-><init>(Landroid/database/Cursor;)V

    invoke-virtual {v11, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_2

    .line 1133
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v3    # "selection":Ljava/lang/String;
    .end local v4    # "whereArgs":[Ljava/lang/String;
    .end local v9    # "c":Landroid/database/Cursor;
    .end local v11    # "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .end local v10    # "isPrivateMessage":Z
    :cond_0
    move v10, v1

    goto :goto_0

    .line 1135
    .restart local v10    # "isPrivateMessage":Z
    :cond_1
    :try_start_1
    const-string v1, "<>?"

    goto :goto_1

    .line 1148
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v3    # "selection":Ljava/lang/String;
    .restart local v4    # "whereArgs":[Ljava/lang/String;
    .restart local v9    # "c":Landroid/database/Cursor;
    .restart local v11    # "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    :cond_2
    invoke-interface {v9}, Landroid/database/Cursor;->close()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1150
    :cond_3
    monitor-exit p0

    return-object v11
.end method

.method public getNumberVisibleMessagesInConversation(JLandroid/database/sqlite/SQLiteDatabase;)I
    .locals 10
    .param p1, "conversationRowId"    # J
    .param p3, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    const/4 v9, 0x0

    .line 3451
    const-string v1, "messages"

    new-array v2, v4, [Ljava/lang/String;

    const-string v0, "_id"

    aput-object v0, v2, v9

    const-string v3, "conversation_row_id =? AND deleted != 1"

    new-array v4, v4, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v4, v9

    move-object v0, p3

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 3454
    .local v8, "c":Landroid/database/Cursor;
    if-eqz v8, :cond_0

    .line 3456
    :try_start_0
    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v9

    .line 3459
    .local v9, "res":I
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 3463
    .end local v9    # "res":I
    :cond_0
    return v9

    .line 3459
    :catchall_0
    move-exception v0

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v0
.end method

.method public declared-synchronized getOldestSortId(I)Landroid/database/Cursor;
    .locals 9
    .param p1, "groupType"    # I

    .prologue
    .line 200
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 201
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "post_groups"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "sort_id"

    aput-object v4, v2, v3

    const-string v3, "post_type=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const-string v7, "CAST (sort_id AS INTEGER) DESC"

    const-string v8, "1"

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    monitor-exit p0

    return-object v1

    .line 200
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getPageAnchor(IILjava/lang/String;)J
    .locals 11
    .param p1, "kind"    # I
    .param p2, "type"    # I
    .param p3, "tag"    # Ljava/lang/String;

    .prologue
    .line 2792
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2793
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "page_cursors"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "anchor"

    aput-object v4, v2, v3

    const-string v3, "kind=? AND type=? AND tag=?"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    invoke-static {p3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v8

    .line 2798
    .local v8, "c":Landroid/database/Cursor;
    const-wide/16 v9, -0x1

    .line 2799
    .local v9, "result":J
    if-eqz v8, :cond_1

    .line 2801
    :try_start_1
    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lez v1, :cond_0

    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2802
    const/4 v1, 0x0

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getLong(I)J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-wide v9

    .line 2805
    :cond_0
    :try_start_2
    invoke-interface {v8}, Landroid/database/Cursor;->close()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2808
    :cond_1
    monitor-exit p0

    return-wide v9

    .line 2805
    :catchall_0
    move-exception v1

    :try_start_3
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 2792
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v8    # "c":Landroid/database/Cursor;
    .end local v9    # "result":J
    :catchall_1
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public getPost(J)Lco/vine/android/api/VinePost;
    .locals 10
    .param p1, "postId"    # J

    .prologue
    const/4 v5, 0x0

    .line 3947
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3948
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "post_comments_likes_view"

    sget-object v2, Lco/vine/android/provider/VineDatabaseSQL$PostCommentsLikesQuery;->PROJECTION:[Ljava/lang/String;

    const-string v3, "post_id =? "

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v6

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 3949
    .local v8, "c":Landroid/database/Cursor;
    if-eqz v8, :cond_1

    .line 3951
    :try_start_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 3952
    invoke-static {v8}, Lco/vine/android/api/VinePost;->from(Landroid/database/Cursor;)Lco/vine/android/api/VinePost;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v9

    .line 3956
    .local v9, "vp":Lco/vine/android/api/VinePost;
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 3959
    .end local v9    # "vp":Lco/vine/android/api/VinePost;
    :goto_0
    return-object v9

    .line 3956
    :cond_0
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    :cond_1
    move-object v9, v5

    .line 3959
    goto :goto_0

    .line 3956
    :catchall_0
    move-exception v1

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method public declared-synchronized getPreviousPageCursor(IILjava/lang/String;Z)I
    .locals 12
    .param p1, "kind"    # I
    .param p2, "type"    # I
    .param p3, "tag"    # Ljava/lang/String;
    .param p4, "reversed"    # Z

    .prologue
    .line 2753
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2755
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    if-eqz p4, :cond_3

    .line 2756
    const-string v9, "next_page"

    .line 2761
    .local v9, "column":Ljava/lang/String;
    :goto_0
    if-nez p3, :cond_0

    .line 2762
    const-string p3, ""

    .line 2765
    :cond_0
    const-string v1, "page_cursors"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    aput-object v9, v2, v3

    const-string v3, "kind=? AND type=? AND tag=?"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    invoke-static {p3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v8

    .line 2769
    .local v8, "c":Landroid/database/Cursor;
    const/4 v11, -0x1

    .line 2770
    .local v11, "result":I
    if-eqz v8, :cond_2

    .line 2772
    :try_start_1
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 2773
    invoke-interface {v8, v9}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v10

    .line 2774
    .local v10, "index":I
    invoke-interface {v8, v10}, Landroid/database/Cursor;->getInt(I)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v11

    .line 2777
    .end local v10    # "index":I
    :cond_1
    :try_start_2
    invoke-interface {v8}, Landroid/database/Cursor;->close()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2780
    :cond_2
    monitor-exit p0

    return v11

    .line 2758
    .end local v8    # "c":Landroid/database/Cursor;
    .end local v9    # "column":Ljava/lang/String;
    .end local v11    # "result":I
    :cond_3
    :try_start_3
    const-string v9, "previous_page"

    .restart local v9    # "column":Ljava/lang/String;
    goto :goto_0

    .line 2777
    .restart local v8    # "c":Landroid/database/Cursor;
    .restart local v11    # "result":I
    :catchall_0
    move-exception v1

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 2753
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v8    # "c":Landroid/database/Cursor;
    .end local v9    # "column":Ljava/lang/String;
    .end local v11    # "result":I
    :catchall_1
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public getUserRemoteIdForUserRowId(J)J
    .locals 11
    .param p1, "userRowId"    # J

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    const/4 v7, 0x0

    .line 3693
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3694
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "users"

    new-array v2, v4, [Ljava/lang/String;

    const-string v3, "user_id"

    aput-object v3, v2, v7

    const-string v3, "_id =? "

    new-array v4, v4, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v7

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 3696
    .local v8, "c":Landroid/database/Cursor;
    const-wide/16 v9, -0x1

    .line 3697
    .local v9, "rowId":J
    if-eqz v8, :cond_1

    .line 3699
    :try_start_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 3700
    const/4 v1, 0x0

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getLong(I)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v9

    .line 3703
    :cond_0
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 3706
    :cond_1
    return-wide v9

    .line 3703
    :catchall_0
    move-exception v1

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method public getUserRowIdForRecipient(Lco/vine/android/api/VineRecipient;)J
    .locals 12
    .param p1, "recipient"    # Lco/vine/android/api/VineRecipient;

    .prologue
    const-wide/16 v3, 0x0

    const/4 v6, 0x1

    const/4 v5, 0x0

    const/4 v7, 0x0

    .line 3710
    iget-wide v1, p1, Lco/vine/android/api/VineRecipient;->recipientId:J

    cmp-long v1, v1, v3

    if-lez v1, :cond_0

    .line 3711
    iget-wide v10, p1, Lco/vine/android/api/VineRecipient;->recipientId:J

    .line 3742
    :goto_0
    return-wide v10

    .line 3712
    :cond_0
    invoke-virtual {p1}, Lco/vine/android/api/VineRecipient;->isFromUser()Z

    move-result v1

    if-eqz v1, :cond_1

    iget-wide v1, p1, Lco/vine/android/api/VineRecipient;->userId:J

    cmp-long v1, v1, v3

    if-lez v1, :cond_1

    .line 3713
    iget-wide v1, p1, Lco/vine/android/api/VineRecipient;->userId:J

    invoke-virtual {p0, v1, v2}, Lco/vine/android/provider/VineDatabaseHelper;->getUserRowIdForUserRemoteId(J)J

    move-result-wide v10

    goto :goto_0

    .line 3716
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3719
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v9, 0x0

    .line 3720
    .local v9, "column":Ljava/lang/String;
    invoke-virtual {p1}, Lco/vine/android/api/VineRecipient;->isFromEmail()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 3721
    const-string v9, "email_address"

    .line 3726
    :cond_2
    :goto_1
    if-eqz v9, :cond_5

    .line 3727
    const-string v1, "users"

    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "_id"

    aput-object v3, v2, v7

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "=? AND "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "user_id"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "= -1"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-array v4, v6, [Ljava/lang/String;

    iget-object v6, p1, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    aput-object v6, v4, v7

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 3731
    .local v8, "c":Landroid/database/Cursor;
    if-eqz v8, :cond_5

    .line 3733
    :try_start_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 3734
    const/4 v1, 0x0

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getLong(I)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v10

    .line 3738
    .local v10, "userRowId":J
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 3722
    .end local v8    # "c":Landroid/database/Cursor;
    .end local v10    # "userRowId":J
    :cond_3
    invoke-virtual {p1}, Lco/vine/android/api/VineRecipient;->isFromPhone()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 3723
    const-string v9, "phone_number"

    goto :goto_1

    .line 3738
    .restart local v8    # "c":Landroid/database/Cursor;
    :cond_4
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 3742
    .end local v8    # "c":Landroid/database/Cursor;
    :cond_5
    const-wide/16 v10, -0x1

    goto :goto_0

    .line 3738
    .restart local v8    # "c":Landroid/database/Cursor;
    :catchall_0
    move-exception v1

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method public getUserRowIdForUserRemoteId(J)J
    .locals 11
    .param p1, "userId"    # J

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    const/4 v7, 0x0

    .line 3676
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3677
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "users"

    new-array v2, v4, [Ljava/lang/String;

    const-string v3, "_id"

    aput-object v3, v2, v7

    const-string v3, "user_id =? "

    new-array v4, v4, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v7

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 3679
    .local v8, "c":Landroid/database/Cursor;
    const-wide/16 v9, -0x1

    .line 3680
    .local v9, "rowId":J
    if-eqz v8, :cond_1

    .line 3682
    :try_start_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 3683
    const/4 v1, 0x0

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getLong(I)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v9

    .line 3686
    :cond_0
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 3689
    :cond_1
    return-wide v9

    .line 3686
    :catchall_0
    move-exception v1

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method public declared-synchronized markChannelLastUsedTimestamp(J)V
    .locals 7
    .param p1, "channelId"    # J

    .prologue
    .line 2597
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2598
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 2599
    .local v1, "values":Landroid/content/ContentValues;
    const-string v2, "last_used_timestamp"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2600
    const-string v2, "channels"

    const-string v3, "channel_id=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v0, v2, v1, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2602
    monitor-exit p0

    return-void

    .line 2597
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "values":Landroid/content/ContentValues;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized markLastChannel()V
    .locals 9

    .prologue
    .line 2566
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getLastChannelRowId()J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v1

    .line 2567
    .local v1, "rowId":J
    const-wide/16 v4, 0x0

    cmp-long v4, v1, v4

    if-nez v4, :cond_0

    .line 2591
    :goto_0
    monitor-exit p0

    return-void

    .line 2571
    :cond_0
    :try_start_1
    sget-boolean v4, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v4, :cond_1

    .line 2572
    const-string v4, "VineDH"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Tagging the oldest channel with row id: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 2575
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2578
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 2579
    .local v3, "values":Landroid/content/ContentValues;
    const-string v4, "is_last"

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2581
    :try_start_2
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 2582
    const-string v4, "channels"

    const-string v5, "is_last=1"

    const/4 v6, 0x0

    invoke-virtual {v0, v4, v3, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2584
    const-string v4, "is_last"

    const/4 v5, 0x1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2585
    const-string v4, "channels"

    const-string v5, "_id=?"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v0, v4, v3, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2588
    :try_start_3
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 2590
    iget-object v4, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v5, Lco/vine/android/provider/Vine$Channels;->CONTENT_URI:Landroid/net/Uri;

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 2566
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "rowId":J
    .end local v3    # "values":Landroid/content/ContentValues;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 2588
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v1    # "rowId":J
    .restart local v3    # "values":Landroid/content/ContentValues;
    :catchall_1
    move-exception v4

    :try_start_4
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0
.end method

.method public declared-synchronized markLastComment(J)V
    .locals 9
    .param p1, "postId"    # J

    .prologue
    .line 2477
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1, p2}, Lco/vine/android/provider/VineDatabaseHelper;->getLastCommentRowId(J)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v1

    .line 2478
    .local v1, "rowId":J
    const-wide/16 v4, 0x0

    cmp-long v4, v1, v4

    if-nez v4, :cond_0

    .line 2500
    :goto_0
    monitor-exit p0

    return-void

    .line 2482
    :cond_0
    :try_start_1
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2484
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 2485
    .local v3, "values":Landroid/content/ContentValues;
    const-string v4, "is_last"

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2488
    :try_start_2
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 2490
    const-string v4, "comments"

    const-string v5, "is_last=1 AND post_id=?"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v0, v4, v3, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2493
    const-string v4, "is_last"

    const/4 v5, 0x1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2494
    const-string v4, "comments"

    const-string v5, "_id=?"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v0, v4, v3, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2496
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2498
    :try_start_3
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 2477
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "rowId":J
    .end local v3    # "values":Landroid/content/ContentValues;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 2498
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v1    # "rowId":J
    .restart local v3    # "values":Landroid/content/ContentValues;
    :catchall_1
    move-exception v4

    :try_start_4
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0
.end method

.method public declared-synchronized markLastConversation(I)V
    .locals 10
    .param p1, "networkType"    # I

    .prologue
    .line 2605
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1}, Lco/vine/android/provider/VineDatabaseHelper;->getLastConversationId(I)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v1

    .line 2606
    .local v1, "rowId":J
    const-wide/16 v5, 0x0

    cmp-long v5, v1, v5

    if-nez v5, :cond_0

    .line 2626
    :goto_0
    monitor-exit p0

    return-void

    .line 2610
    :cond_0
    :try_start_1
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2612
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    .line 2613
    .local v4, "values":Landroid/content/ContentValues;
    const-string v5, "is_last"

    const/4 v6, 0x0

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2616
    :try_start_2
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 2617
    const-string v5, "conversations"

    const-string v6, "is_last=1 AND network_type=?"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-virtual {v0, v5, v4, v6, v7}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v3

    .line 2619
    .local v3, "updated":I
    const-string v5, "is_last"

    const/4 v6, 0x1

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2620
    const-string v5, "conversations"

    const-string v6, "_id=?"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-virtual {v0, v5, v4, v6, v7}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v3

    .line 2622
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2624
    :try_start_3
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 2605
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "rowId":J
    .end local v3    # "updated":I
    .end local v4    # "values":Landroid/content/ContentValues;
    :catchall_0
    move-exception v5

    monitor-exit p0

    throw v5

    .line 2624
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v1    # "rowId":J
    .restart local v4    # "values":Landroid/content/ContentValues;
    :catchall_1
    move-exception v5

    :try_start_4
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v5
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0
.end method

.method public declared-synchronized markLastMessage(J)V
    .locals 9
    .param p1, "conversationRowId"    # J

    .prologue
    .line 2504
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1, p2}, Lco/vine/android/provider/VineDatabaseHelper;->getLastMessageRowId(J)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v1

    .line 2505
    .local v1, "rowId":J
    const-wide/16 v4, 0x0

    cmp-long v4, v1, v4

    if-nez v4, :cond_0

    .line 2526
    :goto_0
    monitor-exit p0

    return-void

    .line 2509
    :cond_0
    :try_start_1
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2511
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 2512
    .local v3, "values":Landroid/content/ContentValues;
    const-string v4, "is_last"

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2515
    :try_start_2
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 2516
    const-string v4, "messages"

    const-string v5, "is_last=1 AND conversation_row_id=?"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v0, v4, v3, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2519
    const-string v4, "is_last"

    const/4 v5, 0x1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2520
    const-string v4, "messages"

    const-string v5, "_id=?"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v0, v4, v3, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2522
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2524
    :try_start_3
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 2504
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "rowId":J
    .end local v3    # "values":Landroid/content/ContentValues;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 2524
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v1    # "rowId":J
    .restart local v3    # "values":Landroid/content/ContentValues;
    :catchall_1
    move-exception v4

    :try_start_4
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0
.end method

.method public declared-synchronized markLastPost(ILjava/lang/String;)V
    .locals 9
    .param p1, "type"    # I
    .param p2, "tag"    # Ljava/lang/String;

    .prologue
    .line 2447
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1, p2}, Lco/vine/android/provider/VineDatabaseHelper;->getLastPostRowId(ILjava/lang/String;)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v1

    .line 2448
    .local v1, "rowId":J
    const-wide/16 v4, 0x0

    cmp-long v4, v1, v4

    if-nez v4, :cond_0

    .line 2473
    :goto_0
    monitor-exit p0

    return-void

    .line 2452
    :cond_0
    :try_start_1
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2454
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    sget-boolean v4, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v4, :cond_1

    .line 2455
    const-string v4, "VineDH"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Tagging the oldest post of type: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " and tag: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " row id: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 2458
    :cond_1
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 2459
    .local v3, "values":Landroid/content/ContentValues;
    const-string v4, "is_last"

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2462
    :try_start_2
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 2463
    const-string v4, "post_groups"

    const-string v5, "is_last=1"

    const/4 v6, 0x0

    invoke-virtual {v0, v4, v3, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2465
    const-string v4, "is_last"

    const/4 v5, 0x1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2466
    const-string v4, "post_groups"

    const-string v5, "_id=?"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v0, v4, v3, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2468
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2470
    :try_start_3
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 2472
    invoke-direct {p0}, Lco/vine/android/provider/VineDatabaseHelper;->notifyPostCommentsViewUris()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 2447
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "rowId":J
    .end local v3    # "values":Landroid/content/ContentValues;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 2470
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v1    # "rowId":J
    .restart local v3    # "values":Landroid/content/ContentValues;
    :catchall_1
    move-exception v4

    :try_start_4
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0
.end method

.method public declared-synchronized markLastTag()V
    .locals 9

    .prologue
    .line 2533
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getLastTagRowId()J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v1

    .line 2534
    .local v1, "rowId":J
    const-wide/16 v4, 0x0

    cmp-long v4, v1, v4

    if-nez v4, :cond_0

    .line 2560
    :goto_0
    monitor-exit p0

    return-void

    .line 2538
    :cond_0
    :try_start_1
    sget-boolean v4, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v4, :cond_1

    .line 2539
    const-string v4, "VineDH"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Tagging the oldest tag with row id: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 2542
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2545
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 2546
    .local v3, "values":Landroid/content/ContentValues;
    const-string v4, "is_last"

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2549
    :try_start_2
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 2550
    const-string v4, "tag_search_results"

    const-string v5, "is_last=1"

    const/4 v6, 0x0

    invoke-virtual {v0, v4, v3, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2552
    const-string v4, "is_last"

    const/4 v5, 0x1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2553
    const-string v4, "tag_search_results"

    const-string v5, "_id=?"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v0, v4, v3, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2555
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 2556
    iget-object v4, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v5, Lco/vine/android/provider/Vine$TagSearchResults;->CONTENT_URI:Landroid/net/Uri;

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2558
    :try_start_3
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 2533
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "rowId":J
    .end local v3    # "values":Landroid/content/ContentValues;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 2558
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v1    # "rowId":J
    .restart local v3    # "values":Landroid/content/ContentValues;
    :catchall_1
    move-exception v4

    :try_start_4
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0
.end method

.method public declared-synchronized markLastUser(ILjava/lang/String;)V
    .locals 1
    .param p1, "type"    # I
    .param p2, "tag"    # Ljava/lang/String;

    .prologue
    .line 2404
    monitor-enter p0

    :try_start_0
    const-string v0, "order_id ASC"

    invoke-virtual {p0, p1, p2, v0}, Lco/vine/android/provider/VineDatabaseHelper;->markLastUser(ILjava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2405
    monitor-exit p0

    return-void

    .line 2404
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized markLastUser(ILjava/lang/String;Ljava/lang/String;)V
    .locals 9
    .param p1, "type"    # I
    .param p2, "tag"    # Ljava/lang/String;
    .param p3, "isLastOrdering"    # Ljava/lang/String;

    .prologue
    .line 2415
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/provider/VineDatabaseHelper;->getLastUserRowId(ILjava/lang/String;Ljava/lang/String;)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v1

    .line 2416
    .local v1, "rowId":J
    const-wide/16 v4, 0x0

    cmp-long v4, v1, v4

    if-nez v4, :cond_0

    .line 2443
    :goto_0
    monitor-exit p0

    return-void

    .line 2420
    :cond_0
    :try_start_1
    sget-boolean v4, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v4, :cond_1

    .line 2421
    const-string v4, "VineDH"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Tagging the oldest user of type: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " row id: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 2424
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2427
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 2428
    .local v3, "values":Landroid/content/ContentValues;
    const-string v4, "is_last"

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2431
    :try_start_2
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 2433
    const-string v4, "user_groups"

    const-string v5, "is_last=1"

    const/4 v6, 0x0

    invoke-virtual {v0, v4, v3, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2435
    const-string v4, "is_last"

    const/4 v5, 0x1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2436
    const-string v4, "user_groups"

    const-string v5, "_id=?"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v0, v4, v3, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2438
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2440
    :try_start_3
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 2442
    iget-object v4, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v5, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI:Landroid/net/Uri;

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 2415
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "rowId":J
    .end local v3    # "values":Landroid/content/ContentValues;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 2440
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v1    # "rowId":J
    .restart local v3    # "values":Landroid/content/ContentValues;
    :catchall_1
    move-exception v4

    :try_start_4
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0
.end method

.method public declared-synchronized mergeChannels(Ljava/util/Collection;II)I
    .locals 14
    .param p2, "next"    # I
    .param p3, "previous"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lco/vine/android/api/VineChannel;",
            ">;II)I"
        }
    .end annotation

    .prologue
    .line 1712
    .local p1, "channels":Ljava/util/Collection;, "Ljava/util/Collection<Lco/vine/android/api/VineChannel;>;"
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v10

    .line 1713
    .local v10, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v12, 0x0

    .line 1714
    .local v12, "inserted":I
    invoke-interface {p1}, Ljava/util/Collection;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 1715
    invoke-virtual {v10}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 1717
    :try_start_1
    const-string v0, "channels"

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {v10, v0, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1718
    new-instance v13, Landroid/content/ContentValues;

    invoke-direct {v13}, Landroid/content/ContentValues;-><init>()V

    .line 1719
    .local v13, "values":Landroid/content/ContentValues;
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v11

    .local v11, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lco/vine/android/api/VineChannel;

    .line 1720
    .local v9, "channel":Lco/vine/android/api/VineChannel;
    invoke-virtual {v13}, Landroid/content/ContentValues;->clear()V

    .line 1721
    invoke-direct {p0, v13, v9}, Lco/vine/android/provider/VineDatabaseHelper;->fillChannelValues(Landroid/content/ContentValues;Lco/vine/android/api/VineChannel;)V

    .line 1722
    const-string v0, "channels"

    const/4 v1, 0x0

    invoke-virtual {v10, v0, v1, v13}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_1
    add-int/2addr v12, v0

    .line 1724
    goto :goto_0

    .line 1722
    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    .line 1725
    .end local v9    # "channel":Lco/vine/android/api/VineChannel;
    :cond_1
    invoke-virtual {v10}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1727
    :try_start_2
    invoke-virtual {p0, v10}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 1731
    .end local v11    # "i$":Ljava/util/Iterator;
    .end local v13    # "values":Landroid/content/ContentValues;
    :cond_2
    if-gtz p2, :cond_3

    if-lez p3, :cond_4

    .line 1732
    :cond_3
    const/4 v1, 0x2

    const/4 v2, 0x0

    const/4 v3, 0x0

    const-wide/16 v6, 0x0

    const/4 v8, 0x1

    move-object v0, p0

    move/from16 v4, p2

    move/from16 v5, p3

    invoke-virtual/range {v0 .. v8}, Lco/vine/android/provider/VineDatabaseHelper;->savePageCursor(IILjava/lang/String;IIJZ)I

    .line 1735
    :cond_4
    if-lez v12, :cond_6

    .line 1736
    sget-boolean v0, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v0, :cond_5

    .line 1737
    const-string v0, "VineDH"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Inserted "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " new channels."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1739
    :cond_5
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v1, Lco/vine/android/provider/Vine$Channels;->CONTENT_URI:Landroid/net/Uri;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 1741
    :cond_6
    monitor-exit p0

    return v12

    .line 1727
    :catchall_0
    move-exception v0

    :try_start_3
    invoke-virtual {p0, v10}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 1712
    .end local v10    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v12    # "inserted":I
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized mergeConversation(JLco/vine/android/api/VineConversation;IIIJ)J
    .locals 10
    .param p1, "sessionOwnerId"    # J
    .param p3, "conversation"    # Lco/vine/android/api/VineConversation;
    .param p4, "networkType"    # I
    .param p5, "nextPage"    # I
    .param p6, "prevPage"    # I
    .param p7, "anchor"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1975
    monitor-enter p0

    :try_start_0
    invoke-virtual/range {p0 .. p8}, Lco/vine/android/provider/VineDatabaseHelper;->mergeMessages(JLco/vine/android/api/VineConversation;IIIJ)J

    move-result-wide v0

    .line 1976
    .local v0, "conversationRowId":J
    iget-object v8, p3, Lco/vine/android/api/VineConversation;->users:Ljava/util/ArrayList;

    if-eqz v8, :cond_2

    .line 1977
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 1978
    .local v7, "userRowIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    iget-object v8, p3, Lco/vine/android/api/VineConversation;->users:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/Long;

    invoke-virtual {v8}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    .line 1979
    .local v3, "user":J
    invoke-virtual {p0, v3, v4}, Lco/vine/android/provider/VineDatabaseHelper;->getUserRowIdForUserRemoteId(J)J

    move-result-wide v5

    .line 1980
    .local v5, "userRowId":J
    const-wide/16 v8, -0x1

    cmp-long v8, v5, v8

    if-lez v8, :cond_0

    .line 1981
    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 1975
    .end local v0    # "conversationRowId":J
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "user":J
    .end local v5    # "userRowId":J
    .end local v7    # "userRowIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    :catchall_0
    move-exception v8

    monitor-exit p0

    throw v8

    .line 1984
    .restart local v0    # "conversationRowId":J
    .restart local v2    # "i$":Ljava/util/Iterator;
    .restart local v7    # "userRowIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    :cond_1
    :try_start_1
    invoke-virtual {p0, v0, v1, v7}, Lco/vine/android/provider/VineDatabaseHelper;->mergeConversationRecipients(JLjava/util/Collection;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1986
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v7    # "userRowIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    :cond_2
    monitor-exit p0

    return-wide v0
.end method

.method public declared-synchronized mergeConversationRecipients(JLjava/util/Collection;)V
    .locals 9
    .param p1, "conversationRowId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1927
    .local p3, "userRowIds":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/Long;>;"
    monitor-enter p0

    const/4 v3, 0x0

    .line 1929
    .local v3, "inserted":I
    :try_start_0
    sget-boolean v5, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v5, :cond_0

    .line 1930
    const-string v5, "VineDH"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "mergeConversations, count="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-interface {p3}, Ljava/util/Collection;->size()I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1933
    :cond_0
    invoke-interface {p3}, Ljava/util/Collection;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_3

    .line 1934
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v0

    .line 1936
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 1937
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    .line 1938
    .local v4, "values":Landroid/content/ContentValues;
    const-string v5, "conversation_row_id"

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1939
    invoke-interface {p3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    .line 1940
    .local v1, "entry":Ljava/lang/Long;
    const-string v5, "user_row_id"

    invoke-virtual {v4, v5, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1941
    const-string v5, "conversation_recipients"

    const/4 v6, 0x0

    invoke-virtual {v0, v5, v6, v4}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v5

    const-wide/16 v7, 0x0

    cmp-long v5, v5, v7

    if-lez v5, :cond_1

    const/4 v5, 0x1

    :goto_1
    add-int/2addr v3, v5

    .line 1943
    goto :goto_0

    .line 1941
    :cond_1
    const/4 v5, 0x0

    goto :goto_1

    .line 1944
    .end local v1    # "entry":Ljava/lang/Long;
    :cond_2
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1946
    :try_start_2
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 1950
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v4    # "values":Landroid/content/ContentValues;
    :cond_3
    if-lez v3, :cond_4

    .line 1951
    iget-object v5, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v6, Lco/vine/android/provider/Vine$InboxView;->CONTENT_URI:Landroid/net/Uri;

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 1953
    :cond_4
    monitor-exit p0

    return-void

    .line 1946
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :catchall_0
    move-exception v5

    :try_start_3
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v5
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 1927
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :catchall_1
    move-exception v5

    monitor-exit p0

    throw v5
.end method

.method public declared-synchronized mergeConversationWithLocalId(JJI)J
    .locals 11
    .param p1, "conversationRowId"    # J
    .param p3, "conversationId"    # J
    .param p5, "networkType"    # I

    .prologue
    .line 2187
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v9

    .line 2188
    .local v9, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v10, 0x0

    .line 2189
    .local v10, "updated":I
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 2190
    .local v1, "values":Landroid/content/ContentValues;
    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-static/range {p5 .. p5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    const/4 v4, 0x0

    const-wide/16 v5, 0x0

    const-wide/16 v7, 0x0

    move-object v0, p0

    invoke-direct/range {v0 .. v8}, Lco/vine/android/provider/VineDatabaseHelper;->fillConversationValues(Landroid/content/ContentValues;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;JJ)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 2192
    :try_start_1
    invoke-virtual {v9}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 2193
    const-string v0, "conversations"

    const-string v2, "_id=?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v9, v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v10

    .line 2195
    if-gtz v10, :cond_0

    .line 2196
    const-string v0, "conversations"

    const/4 v2, 0x0

    invoke-virtual {v9, v0, v2, v1}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide p1

    .line 2198
    :cond_0
    invoke-virtual {v9}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2200
    :try_start_2
    invoke-virtual {p0, v9}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2202
    monitor-exit p0

    return-wide p1

    .line 2200
    :catchall_0
    move-exception v0

    :try_start_3
    invoke-virtual {p0, v9}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 2187
    .end local v1    # "values":Landroid/content/ContentValues;
    .end local v9    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v10    # "updated":I
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized mergeConversationWithRemoteId(JLjava/lang/Integer;Ljava/lang/Boolean;JJ)J
    .locals 19
    .param p1, "conversationId"    # J
    .param p3, "networkType"    # Ljava/lang/Integer;
    .param p4, "hidden"    # Ljava/lang/Boolean;
    .param p5, "unreadMessageCount"    # J
    .param p7, "lastMessage"    # J

    .prologue
    .line 2208
    monitor-enter p0

    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 2209
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v18, "conversation_id=?"

    .line 2210
    .local v18, "selection":Ljava/lang/String;
    const/4 v2, 0x1

    new-array v5, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v5, v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 2213
    .local v5, "selArgs":[Ljava/lang/String;
    :try_start_1
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 2214
    const-string v2, "conversations"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v6, "_id"

    aput-object v6, v3, v4

    const-string v4, "conversation_id=?"

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "1"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v15

    .line 2216
    .local v15, "cursor":Landroid/database/Cursor;
    const-wide/16 v16, -0x1

    .line 2217
    .local v16, "id":J
    if-eqz v15, :cond_1

    .line 2219
    :try_start_2
    invoke-interface {v15}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 2220
    new-instance v7, Landroid/content/ContentValues;

    invoke-direct {v7}, Landroid/content/ContentValues;-><init>()V

    .line 2221
    .local v7, "values":Landroid/content/ContentValues;
    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    move-object/from16 v6, p0

    move-object/from16 v9, p3

    move-object/from16 v10, p4

    move-wide/from16 v11, p5

    move-wide/from16 v13, p7

    invoke-direct/range {v6 .. v14}, Lco/vine/android/provider/VineDatabaseHelper;->fillConversationValues(Landroid/content/ContentValues;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;JJ)V

    .line 2223
    const-string v2, "conversations"

    const-string v3, "conversation_id=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v4, v6

    invoke-virtual {v1, v2, v7, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2225
    const/4 v2, 0x0

    invoke-interface {v15, v2}, Landroid/database/Cursor;->getLong(I)J
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    move-result-wide v16

    .line 2228
    .end local v7    # "values":Landroid/content/ContentValues;
    :cond_0
    :try_start_3
    invoke-interface {v15}, Landroid/database/Cursor;->close()V

    .line 2231
    :cond_1
    const-wide/16 v2, -0x1

    cmp-long v2, v16, v2

    if-nez v2, :cond_2

    .line 2232
    new-instance v7, Landroid/content/ContentValues;

    invoke-direct {v7}, Landroid/content/ContentValues;-><init>()V

    .line 2233
    .restart local v7    # "values":Landroid/content/ContentValues;
    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    move-object/from16 v6, p0

    move-object/from16 v9, p3

    move-object/from16 v10, p4

    move-wide/from16 v11, p5

    move-wide/from16 v13, p7

    invoke-direct/range {v6 .. v14}, Lco/vine/android/provider/VineDatabaseHelper;->fillConversationValues(Landroid/content/ContentValues;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;JJ)V

    .line 2235
    const-string v2, "conversations"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v7}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v16

    .line 2236
    const-wide/16 v2, -0x1

    cmp-long v2, v16, v2

    if-nez v2, :cond_2

    .line 2237
    new-instance v2, Ljava/lang/RuntimeException;

    const-string v3, "Failed to insert conversation."

    invoke-direct {v2, v3}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 2243
    .end local v7    # "values":Landroid/content/ContentValues;
    .end local v15    # "cursor":Landroid/database/Cursor;
    .end local v16    # "id":J
    :catchall_0
    move-exception v2

    :try_start_4
    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 2208
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v5    # "selArgs":[Ljava/lang/String;
    .end local v18    # "selection":Ljava/lang/String;
    :catchall_1
    move-exception v2

    monitor-exit p0

    throw v2

    .line 2228
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v5    # "selArgs":[Ljava/lang/String;
    .restart local v15    # "cursor":Landroid/database/Cursor;
    .restart local v16    # "id":J
    .restart local v18    # "selection":Ljava/lang/String;
    :catchall_2
    move-exception v2

    :try_start_5
    invoke-interface {v15}, Landroid/database/Cursor;->close()V

    throw v2

    .line 2240
    :cond_2
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 2243
    :try_start_6
    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    monitor-exit p0

    return-wide v16
.end method

.method public declared-synchronized mergeEditions(Ljava/util/ArrayList;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 3290
    .local p1, "items":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;>;"
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3292
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v5, "editions"

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual {v0, v5, v6, v7}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 3294
    const/4 v3, 0x0

    .line 3295
    .local v3, "numInserted":I
    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_1

    .line 3296
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 3298
    :try_start_1
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    .line 3299
    .local v4, "values":Landroid/content/ContentValues;
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/util/Pair;

    .line 3300
    .local v1, "edition":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v6, "edition_code"

    iget-object v5, v1, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v5, Ljava/lang/String;

    invoke-virtual {v4, v6, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3301
    const-string v6, "edition_name"

    iget-object v5, v1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v5, Ljava/lang/String;

    invoke-virtual {v4, v6, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3302
    int-to-long v5, v3

    const-string v7, "editions"

    const/4 v8, 0x0

    invoke-virtual {v0, v7, v8, v4}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v7

    add-long/2addr v5, v7

    long-to-int v3, v5

    .line 3303
    goto :goto_0

    .line 3304
    .end local v1    # "edition":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 3306
    :try_start_2
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 3310
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v4    # "values":Landroid/content/ContentValues;
    :cond_1
    if-lez v3, :cond_2

    .line 3311
    iget-object v5, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v6, Lco/vine/android/provider/Vine$Editions;->CONTENT_URI:Landroid/net/Uri;

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 3313
    :cond_2
    monitor-exit p0

    return-void

    .line 3306
    :catchall_0
    move-exception v5

    :try_start_3
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v5
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 3290
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v3    # "numInserted":I
    :catchall_1
    move-exception v5

    monitor-exit p0

    throw v5
.end method

.method public declared-synchronized mergeInbox(JLco/vine/android/api/VineParsers$VinePagedInbox;IIJII)V
    .locals 15
    .param p1, "sessionOwnerId"    # J
    .param p3, "inbox"    # Lco/vine/android/api/VineParsers$VinePagedInbox;
    .param p4, "next"    # I
    .param p5, "previous"    # I
    .param p6, "anchor"    # J
    .param p8, "networkType"    # I
    .param p9, "userGroup"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1960
    monitor-enter p0

    :try_start_0
    move-object/from16 v0, p3

    iget-object v1, v0, Lco/vine/android/api/VineParsers$VinePagedInbox;->participants:Ljava/util/ArrayList;

    if-eqz v1, :cond_0

    move-object/from16 v0, p3

    iget-object v1, v0, Lco/vine/android/api/VineParsers$VinePagedInbox;->participants:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 1961
    move-object/from16 v0, p3

    iget-object v2, v0, Lco/vine/android/api/VineParsers$VinePagedInbox;->participants:Ljava/util/ArrayList;

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v1, p0

    move/from16 v3, p9

    invoke-virtual/range {v1 .. v7}, Lco/vine/android/provider/VineDatabaseHelper;->mergeUsers(Ljava/util/Collection;ILjava/lang/String;IILco/vine/android/util/LongSparseArray;)I

    .line 1965
    :cond_0
    move-object/from16 v0, p3

    iget-object v1, v0, Lco/vine/android/api/VineParsers$VinePagedInbox;->items:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v14

    .local v14, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v14}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v14}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/api/VineConversation;

    .line 1966
    .local v4, "conversation":Lco/vine/android/api/VineConversation;
    const/4 v6, 0x0

    const/4 v7, 0x0

    const-wide/16 v8, 0x0

    move-object v1, p0

    move-wide/from16 v2, p1

    move/from16 v5, p8

    invoke-virtual/range {v1 .. v9}, Lco/vine/android/provider/VineDatabaseHelper;->mergeConversation(JLco/vine/android/api/VineConversation;IIIJ)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 1960
    .end local v4    # "conversation":Lco/vine/android/api/VineConversation;
    .end local v14    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 1969
    .restart local v14    # "i$":Ljava/util/Iterator;
    :cond_1
    if-gtz p4, :cond_2

    if-gtz p5, :cond_2

    const-wide/16 v1, 0x0

    cmp-long v1, p6, v1

    if-lez v1, :cond_3

    .line 1970
    :cond_2
    const/4 v6, 0x6

    const/4 v8, 0x0

    const/4 v13, 0x0

    move-object v5, p0

    move/from16 v7, p8

    move/from16 v9, p4

    move/from16 v10, p5

    move-wide/from16 v11, p6

    :try_start_1
    invoke-virtual/range {v5 .. v13}, Lco/vine/android/provider/VineDatabaseHelper;->savePageCursor(IILjava/lang/String;IIJZ)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1972
    :cond_3
    monitor-exit p0

    return-void
.end method

.method public declared-synchronized mergeLikes(Ljava/util/Collection;JII)I
    .locals 44
    .param p2, "postId"    # J
    .param p4, "next"    # I
    .param p5, "previous"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lco/vine/android/api/VineLike;",
            ">;JII)I"
        }
    .end annotation

    .prologue
    .line 562
    .local p1, "items":Ljava/util/Collection;, "Ljava/util/Collection<Lco/vine/android/api/VineLike;>;"
    monitor-enter p0

    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v5

    .line 564
    .local v5, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v31, Lco/vine/android/util/LongSparseArray;

    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->size()I

    move-result v6

    move-object/from16 v0, v31

    invoke-direct {v0, v6}, Lco/vine/android/util/LongSparseArray;-><init>(I)V

    .line 566
    .local v31, "newLikes":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VineLike;>;"
    new-instance v41, Lco/vine/android/util/LongSparseArray;

    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->size()I

    move-result v6

    move-object/from16 v0, v41

    invoke-direct {v0, v6}, Lco/vine/android/util/LongSparseArray;-><init>(I)V

    .line 568
    .local v41, "updatedLikes":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VineLike;>;"
    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v24

    .local v24, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface/range {v24 .. v24}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface/range {v24 .. v24}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v27

    check-cast v27, Lco/vine/android/api/VineLike;

    .line 569
    .local v27, "like":Lco/vine/android/api/VineLike;
    move-wide/from16 v0, p2

    move-object/from16 v2, v27

    iput-wide v0, v2, Lco/vine/android/api/VineLike;->postId:J

    .line 570
    move-object/from16 v0, v27

    iget-wide v8, v0, Lco/vine/android/api/VineLike;->likeId:J

    move-object/from16 v0, v31

    move-object/from16 v1, v27

    invoke-virtual {v0, v8, v9, v1}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 562
    .end local v5    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v24    # "i$":Ljava/util/Iterator;
    .end local v27    # "like":Lco/vine/android/api/VineLike;
    .end local v31    # "newLikes":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VineLike;>;"
    .end local v41    # "updatedLikes":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VineLike;>;"
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6

    .line 573
    .restart local v5    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v24    # "i$":Ljava/util/Iterator;
    .restart local v31    # "newLikes":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VineLike;>;"
    .restart local v41    # "updatedLikes":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VineLike;>;"
    :cond_0
    :try_start_1
    const-string v6, "likes"

    sget-object v7, Lco/vine/android/provider/VineDatabaseSQL$LikesQuery;->PROJECTION:[Ljava/lang/String;

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    invoke-virtual/range {v5 .. v12}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v21

    .line 576
    .local v21, "c":Landroid/database/Cursor;
    if-eqz v21, :cond_3

    .line 578
    :cond_1
    :goto_1
    :try_start_2
    invoke-interface/range {v21 .. v21}, Landroid/database/Cursor;->moveToNext()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 579
    const/4 v6, 0x1

    move-object/from16 v0, v21

    invoke-interface {v0, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v28

    .line 580
    .local v28, "likeId":J
    move-object/from16 v0, v31

    move-wide/from16 v1, v28

    invoke-virtual {v0, v1, v2}, Lco/vine/android/util/LongSparseArray;->removeKey(J)Ljava/lang/Object;

    move-result-object v27

    check-cast v27, Lco/vine/android/api/VineLike;

    .line 581
    .restart local v27    # "like":Lco/vine/android/api/VineLike;
    if-eqz v27, :cond_1

    .line 582
    move-object/from16 v0, v41

    move-wide/from16 v1, v28

    move-object/from16 v3, v27

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_1

    .line 586
    .end local v27    # "like":Lco/vine/android/api/VineLike;
    .end local v28    # "likeId":J
    :catchall_1
    move-exception v6

    :try_start_3
    invoke-interface/range {v21 .. v21}, Landroid/database/Cursor;->close()V

    throw v6

    :cond_2
    invoke-interface/range {v21 .. v21}, Landroid/database/Cursor;->close()V

    .line 590
    :cond_3
    invoke-virtual/range {v31 .. v31}, Lco/vine/android/util/LongSparseArray;->size()I

    move-result v6

    invoke-virtual/range {v41 .. v41}, Lco/vine/android/util/LongSparseArray;->size()I

    move-result v8

    add-int v39, v6, v8

    .line 591
    .local v39, "totalSize":I
    new-instance v12, Lco/vine/android/util/LongSparseArray;

    move/from16 v0, v39

    invoke-direct {v12, v0}, Lco/vine/android/util/LongSparseArray;-><init>(I)V

    .line 592
    .local v12, "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    new-instance v7, Ljava/util/ArrayList;

    move/from16 v0, v39

    invoke-direct {v7, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 594
    .local v7, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    invoke-virtual/range {v31 .. v31}, Lco/vine/android/util/LongSparseArray;->size()I

    move-result v30

    .line 596
    .local v30, "newLikeSize":I
    const/16 v23, 0x0

    .local v23, "i":I
    :goto_2
    move/from16 v0, v23

    move/from16 v1, v30

    if-ge v0, v1, :cond_5

    .line 597
    move-object/from16 v0, v31

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Lco/vine/android/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v43

    check-cast v43, Lco/vine/android/api/VineLike;

    .line 598
    .local v43, "vc":Lco/vine/android/api/VineLike;
    move-object/from16 v0, v43

    iget-object v6, v0, Lco/vine/android/api/VineLike;->user:Lco/vine/android/api/VineUser;

    if-eqz v6, :cond_4

    .line 599
    move-object/from16 v0, v43

    iget-object v6, v0, Lco/vine/android/api/VineLike;->user:Lco/vine/android/api/VineUser;

    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 600
    move-object/from16 v0, v43

    iget-object v6, v0, Lco/vine/android/api/VineLike;->user:Lco/vine/android/api/VineUser;

    iget-wide v8, v6, Lco/vine/android/api/VineUser;->userId:J

    move-object/from16 v0, v43

    iget-wide v10, v0, Lco/vine/android/api/VineLike;->likeId:J

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v12, v8, v9, v6}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 596
    :cond_4
    add-int/lit8 v23, v23, 0x1

    goto :goto_2

    .line 603
    .end local v43    # "vc":Lco/vine/android/api/VineLike;
    :cond_5
    invoke-virtual/range {v41 .. v41}, Lco/vine/android/util/LongSparseArray;->size()I

    move-result v40

    .line 605
    .local v40, "updatedLikeSize":I
    const/16 v23, 0x0

    :goto_3
    move/from16 v0, v23

    move/from16 v1, v40

    if-ge v0, v1, :cond_7

    .line 606
    move-object/from16 v0, v41

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Lco/vine/android/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v43

    check-cast v43, Lco/vine/android/api/VineLike;

    .line 607
    .restart local v43    # "vc":Lco/vine/android/api/VineLike;
    move-object/from16 v0, v43

    iget-object v6, v0, Lco/vine/android/api/VineLike;->user:Lco/vine/android/api/VineUser;

    if-eqz v6, :cond_6

    .line 608
    move-object/from16 v0, v43

    iget-object v6, v0, Lco/vine/android/api/VineLike;->user:Lco/vine/android/api/VineUser;

    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 609
    move-object/from16 v0, v43

    iget-object v6, v0, Lco/vine/android/api/VineLike;->user:Lco/vine/android/api/VineUser;

    iget-wide v8, v6, Lco/vine/android/api/VineUser;->userId:J

    move-object/from16 v0, v43

    iget-wide v10, v0, Lco/vine/android/api/VineLike;->likeId:J

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v12, v8, v9, v6}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 605
    :cond_6
    add-int/lit8 v23, v23, 0x1

    goto :goto_3

    .line 614
    .end local v43    # "vc":Lco/vine/android/api/VineLike;
    :cond_7
    invoke-virtual {v7}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_8

    .line 615
    const/4 v8, 0x5

    invoke-static/range {p2 .. p3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    move-object/from16 v6, p0

    move/from16 v10, p4

    move/from16 v11, p5

    invoke-virtual/range {v6 .. v12}, Lco/vine/android/provider/VineDatabaseHelper;->mergeUsers(Ljava/util/Collection;ILjava/lang/String;IILco/vine/android/util/LongSparseArray;)I

    .line 619
    :cond_8
    const/16 v32, 0x0

    .line 620
    .local v32, "numInserted":I
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v25

    .line 621
    .local v25, "lastRefresh":J
    if-lez v30, :cond_b

    .line 622
    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 624
    :try_start_4
    new-instance v42, Landroid/content/ContentValues;

    invoke-direct/range {v42 .. v42}, Landroid/content/ContentValues;-><init>()V

    .line 625
    .local v42, "values":Landroid/content/ContentValues;
    const/16 v23, 0x0

    :goto_4
    move/from16 v0, v23

    move/from16 v1, v30

    if-ge v0, v1, :cond_a

    .line 626
    move-object/from16 v0, v31

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Lco/vine/android/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v27

    check-cast v27, Lco/vine/android/api/VineLike;

    .line 627
    .restart local v27    # "like":Lco/vine/android/api/VineLike;
    invoke-virtual/range {v42 .. v42}, Landroid/content/ContentValues;->clear()V

    .line 628
    move-object/from16 v0, p0

    move-object/from16 v1, v42

    move-object/from16 v2, v27

    move-wide/from16 v3, v25

    invoke-direct {v0, v1, v2, v3, v4}, Lco/vine/android/provider/VineDatabaseHelper;->fillLikeValues(Landroid/content/ContentValues;Lco/vine/android/api/VineLike;J)V

    .line 629
    const-string v6, "likes"

    const/4 v8, 0x0

    move-object/from16 v0, v42

    invoke-virtual {v5, v6, v8, v0}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v8

    const-wide/16 v10, 0x0

    cmp-long v6, v8, v10

    if-lez v6, :cond_9

    const/4 v6, 0x1

    :goto_5
    add-int v32, v32, v6

    .line 625
    add-int/lit8 v23, v23, 0x1

    goto :goto_4

    .line 629
    :cond_9
    const/4 v6, 0x0

    goto :goto_5

    .line 631
    .end local v27    # "like":Lco/vine/android/api/VineLike;
    :cond_a
    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 633
    :try_start_5
    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 637
    .end local v42    # "values":Landroid/content/ContentValues;
    :cond_b
    const/16 v33, 0x0

    .line 638
    .local v33, "numUpdated":I
    if-lez v40, :cond_e

    .line 639
    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 641
    :try_start_6
    new-instance v42, Landroid/content/ContentValues;

    invoke-direct/range {v42 .. v42}, Landroid/content/ContentValues;-><init>()V

    .line 642
    .restart local v42    # "values":Landroid/content/ContentValues;
    const/16 v23, 0x0

    :goto_6
    move/from16 v0, v23

    move/from16 v1, v40

    if-ge v0, v1, :cond_d

    .line 643
    move-object/from16 v0, v41

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Lco/vine/android/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v27

    check-cast v27, Lco/vine/android/api/VineLike;

    .line 644
    .restart local v27    # "like":Lco/vine/android/api/VineLike;
    invoke-virtual/range {v42 .. v42}, Landroid/content/ContentValues;->clear()V

    .line 645
    move-object/from16 v0, p0

    move-object/from16 v1, v42

    move-object/from16 v2, v27

    move-wide/from16 v3, v25

    invoke-direct {v0, v1, v2, v3, v4}, Lco/vine/android/provider/VineDatabaseHelper;->fillLikeValues(Landroid/content/ContentValues;Lco/vine/android/api/VineLike;J)V

    .line 646
    const-string v6, "likes"

    const-string v8, "like_id=?"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/String;

    const/4 v10, 0x0

    move-object/from16 v0, v27

    iget-wide v13, v0, Lco/vine/android/api/VineLike;->likeId:J

    invoke-static {v13, v14}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    move-object/from16 v0, v42

    invoke-virtual {v5, v6, v0, v8, v9}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_3

    move-result v6

    if-lez v6, :cond_c

    const/4 v6, 0x1

    :goto_7
    add-int v33, v33, v6

    .line 642
    add-int/lit8 v23, v23, 0x1

    goto :goto_6

    .line 633
    .end local v27    # "like":Lco/vine/android/api/VineLike;
    .end local v33    # "numUpdated":I
    .end local v42    # "values":Landroid/content/ContentValues;
    :catchall_2
    move-exception v6

    :try_start_7
    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v6
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 646
    .restart local v27    # "like":Lco/vine/android/api/VineLike;
    .restart local v33    # "numUpdated":I
    .restart local v42    # "values":Landroid/content/ContentValues;
    :cond_c
    const/4 v6, 0x0

    goto :goto_7

    .line 649
    .end local v27    # "like":Lco/vine/android/api/VineLike;
    :cond_d
    :try_start_8
    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_3

    .line 651
    :try_start_9
    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 657
    .end local v42    # "values":Landroid/content/ContentValues;
    :cond_e
    const/16 v22, 0x0

    .line 658
    .local v22, "deleted":I
    if-lez v32, :cond_12

    .line 659
    const-string v14, "likes"

    sget-object v15, Lco/vine/android/provider/VineDatabaseSQL$TableQuery;->PROJECTION:[Ljava/lang/String;

    const/16 v16, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    const/16 v20, 0x0

    move-object v13, v5

    invoke-virtual/range {v13 .. v20}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    move-result-object v38

    .line 661
    .local v38, "tableCursor":Landroid/database/Cursor;
    if-eqz v38, :cond_12

    .line 663
    :try_start_a
    invoke-interface/range {v38 .. v38}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v6

    if-eqz v6, :cond_11

    .line 664
    invoke-interface/range {v38 .. v38}, Landroid/database/Cursor;->getCount()I
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_6

    move-result v37

    .line 665
    .local v37, "size":I
    const/16 v6, 0x1388

    move/from16 v0, v37

    if-le v0, v6, :cond_11

    .line 667
    :try_start_b
    const-string v6, "SELECT last_refresh FROM likes ORDER BY last_refresh DESC LIMIT 1 OFFSET 2500"

    const/4 v8, 0x0

    invoke-virtual {v5, v6, v8}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v36

    .line 673
    .local v36, "oldestNthRow":Landroid/database/Cursor;
    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_5

    .line 674
    if-eqz v36, :cond_10

    .line 676
    :try_start_c
    invoke-interface/range {v36 .. v36}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v6

    if-eqz v6, :cond_f

    .line 677
    const/4 v6, 0x0

    move-object/from16 v0, v36

    invoke-interface {v0, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v34

    .line 678
    .local v34, "oldestNthId":J
    const-string v6, "likes"

    const-string v8, "last_refresh<?"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/String;

    const/4 v10, 0x0

    invoke-static/range {v34 .. v35}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-virtual {v5, v6, v8, v9}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v22

    .line 680
    sget-boolean v6, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v6, :cond_f

    .line 681
    const-string v6, "s"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Due to reaching maximum table size ("

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    move/from16 v0, v37

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " with a max of "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const/16 v9, 0x1388

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "), deleted "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    move/from16 v0, v22

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " likes, all less than refresh time "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    move-wide/from16 v0, v34

    invoke-virtual {v8, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v6, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_4

    .line 688
    .end local v34    # "oldestNthId":J
    :cond_f
    :try_start_d
    invoke-interface/range {v36 .. v36}, Landroid/database/Cursor;->close()V

    .line 691
    :cond_10
    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_5

    .line 693
    :try_start_e
    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_6

    .line 698
    .end local v36    # "oldestNthRow":Landroid/database/Cursor;
    .end local v37    # "size":I
    :cond_11
    :try_start_f
    invoke-interface/range {v38 .. v38}, Landroid/database/Cursor;->close()V

    .line 703
    .end local v38    # "tableCursor":Landroid/database/Cursor;
    :cond_12
    if-gtz v32, :cond_13

    if-gtz v33, :cond_13

    if-lez v22, :cond_14

    .line 704
    :cond_13
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v8, Lco/vine/android/provider/Vine$Likes;->CONTENT_URI:Landroid/net/Uri;

    const/4 v9, 0x0

    invoke-virtual {v6, v8, v9}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 706
    :cond_14
    sget-boolean v6, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v6, :cond_15

    .line 707
    const-string v6, "VineDH"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Inserted "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    move/from16 v0, v32

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " likes and updated "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    move/from16 v0, v33

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "."

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v6, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_f
    .catchall {:try_start_f .. :try_end_f} :catchall_0

    .line 709
    :cond_15
    monitor-exit p0

    return v32

    .line 651
    .end local v22    # "deleted":I
    :catchall_3
    move-exception v6

    :try_start_10
    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v6
    :try_end_10
    .catchall {:try_start_10 .. :try_end_10} :catchall_0

    .line 688
    .restart local v22    # "deleted":I
    .restart local v36    # "oldestNthRow":Landroid/database/Cursor;
    .restart local v37    # "size":I
    .restart local v38    # "tableCursor":Landroid/database/Cursor;
    :catchall_4
    move-exception v6

    :try_start_11
    invoke-interface/range {v36 .. v36}, Landroid/database/Cursor;->close()V

    throw v6
    :try_end_11
    .catchall {:try_start_11 .. :try_end_11} :catchall_5

    .line 693
    .end local v36    # "oldestNthRow":Landroid/database/Cursor;
    :catchall_5
    move-exception v6

    :try_start_12
    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v6
    :try_end_12
    .catchall {:try_start_12 .. :try_end_12} :catchall_6

    .line 698
    .end local v37    # "size":I
    :catchall_6
    move-exception v6

    :try_start_13
    invoke-interface/range {v38 .. v38}, Landroid/database/Cursor;->close()V

    throw v6
    :try_end_13
    .catchall {:try_start_13 .. :try_end_13} :catchall_0
.end method

.method public declared-synchronized mergeMessage(JLco/vine/android/api/VinePrivateMessage;)J
    .locals 23
    .param p1, "conversationRowId"    # J
    .param p3, "message"    # Lco/vine/android/api/VinePrivateMessage;

    .prologue
    .line 2282
    monitor-enter p0

    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v12

    .line 2283
    .local v12, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-wide/16 v13, -0x1

    .line 2284
    .local v13, "inserted":J
    const-wide/16 v18, -0x1

    .line 2286
    .local v18, "updated":J
    new-instance v20, Landroid/content/ContentValues;

    invoke-direct/range {v20 .. v20}, Landroid/content/ContentValues;-><init>()V

    .line 2287
    .local v20, "values":Landroid/content/ContentValues;
    move-object/from16 v0, p0

    move-object/from16 v1, v20

    move-wide/from16 v2, p1

    move-object/from16 v4, p3

    invoke-direct {v0, v1, v2, v3, v4}, Lco/vine/android/provider/VineDatabaseHelper;->fillMessageValues(Landroid/content/ContentValues;JLco/vine/android/api/VinePrivateMessage;)V

    .line 2290
    const-wide/16 v5, -0x1

    cmp-long v5, v13, v5

    if-nez v5, :cond_2

    move-object/from16 v0, p3

    iget-wide v5, v0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    const-wide/16 v7, 0x0

    cmp-long v5, v5, v7

    if-lez v5, :cond_2

    .line 2291
    const-string v17, "message_id=?"

    .line 2292
    .local v17, "selection":Ljava/lang/String;
    const/4 v5, 0x1

    new-array v9, v5, [Ljava/lang/String;

    const/4 v5, 0x0

    move-object/from16 v0, p3

    iget-wide v6, v0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v9, v5

    .line 2293
    .local v9, "selArgs":[Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v6, Lco/vine/android/provider/Vine$Messages;->CONTENT_URI:Landroid/net/Uri;

    sget-object v7, Lco/vine/android/provider/VineDatabaseSQL$MessagesQuery;->PROJECTION:[Ljava/lang/String;

    const-string v8, "message_id=?"

    const/4 v10, 0x0

    invoke-virtual/range {v5 .. v10}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 2295
    .local v11, "cursor":Landroid/database/Cursor;
    if-eqz v11, :cond_2

    .line 2296
    invoke-interface {v11}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 2297
    const/16 v5, 0xd

    invoke-interface {v11, v5}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v15

    .line 2298
    .local v15, "local":J
    move-object/from16 v0, p3

    iget-wide v5, v0, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    cmp-long v5, v15, v5

    if-lez v5, :cond_0

    .line 2299
    const-string v5, "local_start_time"

    invoke-static/range {v15 .. v16}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    move-object/from16 v0, v20

    invoke-virtual {v0, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 2302
    :cond_0
    :try_start_1
    invoke-virtual {v12}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 2303
    const-string v5, "messages"

    const-string v6, "message_id=?"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    move-object/from16 v0, p3

    iget-wide v0, v0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    move-wide/from16 v21, v0

    invoke-static/range {v21 .. v22}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v7, v8

    move-object/from16 v0, v20

    invoke-virtual {v12, v5, v0, v6, v7}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v5

    int-to-long v0, v5

    move-wide/from16 v18, v0

    .line 2305
    invoke-virtual {v12}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2307
    :try_start_2
    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 2310
    .end local v15    # "local":J
    :cond_1
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 2315
    .end local v9    # "selArgs":[Ljava/lang/String;
    .end local v11    # "cursor":Landroid/database/Cursor;
    .end local v17    # "selection":Ljava/lang/String;
    :cond_2
    const-wide/16 v5, -0x1

    cmp-long v5, v13, v5

    if-nez v5, :cond_3

    const-wide/16 v5, 0x0

    cmp-long v5, v18, v5

    if-gtz v5, :cond_3

    .line 2316
    const-string v5, "deleted"

    const-string v6, "0"

    move-object/from16 v0, v20

    invoke-virtual {v0, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2317
    const-string v5, "messages"

    const/4 v6, 0x0

    move-object/from16 v0, v20

    invoke-virtual {v12, v5, v6, v0}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v13

    .line 2320
    :cond_3
    const-wide/16 v5, 0x0

    cmp-long v5, v13, v5

    if-gtz v5, :cond_4

    const-wide/16 v5, 0x0

    cmp-long v5, v18, v5

    if-lez v5, :cond_5

    .line 2321
    :cond_4
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v6, Lco/vine/android/provider/Vine$ConversationMessageUsersView;->CONTENT_URI:Landroid/net/Uri;

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 2322
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v6, Lco/vine/android/provider/Vine$InboxView;->CONTENT_URI:Landroid/net/Uri;

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2324
    :cond_5
    monitor-exit p0

    return-wide v13

    .line 2307
    .restart local v9    # "selArgs":[Ljava/lang/String;
    .restart local v11    # "cursor":Landroid/database/Cursor;
    .restart local v15    # "local":J
    .restart local v17    # "selection":Ljava/lang/String;
    :catchall_0
    move-exception v5

    :try_start_3
    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v5
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 2282
    .end local v9    # "selArgs":[Ljava/lang/String;
    .end local v11    # "cursor":Landroid/database/Cursor;
    .end local v12    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v13    # "inserted":J
    .end local v15    # "local":J
    .end local v17    # "selection":Ljava/lang/String;
    .end local v18    # "updated":J
    .end local v20    # "values":Landroid/content/ContentValues;
    :catchall_1
    move-exception v5

    monitor-exit p0

    throw v5
.end method

.method public declared-synchronized mergeMessageWithMessageRow(JJLco/vine/android/api/VinePrivateMessage;)J
    .locals 14
    .param p1, "messageRowId"    # J
    .param p3, "conversationRowId"    # J
    .param p5, "message"    # Lco/vine/android/api/VinePrivateMessage;

    .prologue
    .line 2248
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v3

    .line 2250
    .local v3, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-wide/16 v4, -0x1

    .line 2251
    .local v4, "inserted":J
    const-wide/16 v6, -0x1

    .line 2253
    .local v6, "updated":J
    new-instance v8, Landroid/content/ContentValues;

    invoke-direct {v8}, Landroid/content/ContentValues;-><init>()V

    .line 2254
    .local v8, "values":Landroid/content/ContentValues;
    move-wide/from16 v0, p3

    move-object/from16 v2, p5

    invoke-direct {p0, v8, v0, v1, v2}, Lco/vine/android/provider/VineDatabaseHelper;->fillMessageValues(Landroid/content/ContentValues;JLco/vine/android/api/VinePrivateMessage;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 2257
    :try_start_1
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 2258
    const-string v9, "messages"

    const-string v10, "_id=?"

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/String;

    const/4 v12, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v13

    aput-object v13, v11, v12

    invoke-virtual {v3, v9, v8, v10, v11}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v9

    int-to-long v6, v9

    .line 2260
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2262
    :try_start_2
    invoke-virtual {p0, v3}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 2265
    const-wide/16 v9, 0x0

    cmp-long v9, v6, v9

    if-gtz v9, :cond_0

    .line 2266
    const-string v9, "deleted"

    const-string v10, "0"

    invoke-virtual {v8, v9, v10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2267
    const-string v9, "messages"

    const/4 v10, 0x0

    invoke-virtual {v3, v9, v10, v8}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v4

    .line 2270
    :cond_0
    const-wide/16 v9, 0x0

    cmp-long v9, v4, v9

    if-gtz v9, :cond_1

    const-wide/16 v9, 0x0

    cmp-long v9, v6, v9

    if-lez v9, :cond_2

    .line 2271
    :cond_1
    iget-object v9, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v10, Lco/vine/android/provider/Vine$ConversationMessageUsersView;->CONTENT_URI:Landroid/net/Uri;

    const/4 v11, 0x0

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 2272
    iget-object v9, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v10, Lco/vine/android/provider/Vine$InboxView;->CONTENT_URI:Landroid/net/Uri;

    const/4 v11, 0x0

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2274
    :cond_2
    const-wide/16 v9, 0x0

    cmp-long v9, v4, v9

    if-lez v9, :cond_3

    .line 2277
    .end local v4    # "inserted":J
    :goto_0
    monitor-exit p0

    return-wide v4

    .line 2262
    .restart local v4    # "inserted":J
    :catchall_0
    move-exception v9

    :try_start_3
    invoke-virtual {p0, v3}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v9
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 2248
    .end local v3    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v4    # "inserted":J
    .end local v6    # "updated":J
    .end local v8    # "values":Landroid/content/ContentValues;
    :catchall_1
    move-exception v9

    monitor-exit p0

    throw v9

    .restart local v3    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v4    # "inserted":J
    .restart local v6    # "updated":J
    .restart local v8    # "values":Landroid/content/ContentValues;
    :cond_3
    move-wide v4, p1

    .line 2277
    goto :goto_0
.end method

.method public declared-synchronized mergeMessages(JLco/vine/android/api/VineConversation;IIIJ)J
    .locals 49
    .param p1, "sessionOwnerId"    # J
    .param p3, "conversation"    # Lco/vine/android/api/VineConversation;
    .param p4, "networkType"    # I
    .param p5, "nextPage"    # I
    .param p6, "prevPage"    # I
    .param p7, "anchor"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2011
    monitor-enter p0

    :try_start_0
    new-instance v37, Ljava/util/LinkedHashMap;

    invoke-direct/range {v37 .. v37}, Ljava/util/LinkedHashMap;-><init>()V

    .line 2012
    .local v37, "newMessages":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/Long;Lco/vine/android/api/VinePrivateMessage;>;"
    new-instance v44, Ljava/util/LinkedHashMap;

    invoke-direct/range {v44 .. v44}, Ljava/util/LinkedHashMap;-><init>()V

    .line 2013
    .local v44, "updatedMessages":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/Long;Lco/vine/android/api/VinePrivateMessage;>;"
    new-instance v45, Ljava/util/HashMap;

    invoke-direct/range {v45 .. v45}, Ljava/util/HashMap;-><init>()V

    .line 2015
    .local v45, "userIdToUserRowMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Long;Ljava/lang/Long;>;"
    move-object/from16 v0, p3

    iget-wide v6, v0, Lco/vine/android/api/VineConversation;->conversationId:J

    .line 2016
    .local v6, "conversationId":J
    invoke-static/range {p4 .. p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    const/4 v9, 0x0

    move-object/from16 v0, p3

    iget-wide v10, v0, Lco/vine/android/api/VineConversation;->unreadMessageCount:J

    const-wide/16 v12, 0x0

    move-object/from16 v5, p0

    invoke-virtual/range {v5 .. v13}, Lco/vine/android/provider/VineDatabaseHelper;->mergeConversationWithRemoteId(JLjava/lang/Integer;Ljava/lang/Boolean;JJ)J

    move-result-wide v30

    .line 2018
    .local v30, "conversationRowId":J
    const-wide v38, 0x7fffffffffffffffL

    .line 2020
    .local v38, "oldestMessageId":J
    move-object/from16 v0, p3

    iget-object v5, v0, Lco/vine/android/api/VineConversation;->messages:Ljava/util/ArrayList;

    if-eqz v5, :cond_2

    .line 2021
    move-object/from16 v0, p3

    iget-object v5, v0, Lco/vine/android/api/VineConversation;->messages:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v34

    .local v34, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface/range {v34 .. v34}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface/range {v34 .. v34}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v36

    check-cast v36, Lco/vine/android/api/VinePrivateMessage;

    .line 2022
    .local v36, "message":Lco/vine/android/api/VinePrivateMessage;
    move-object/from16 v0, v36

    iget-wide v9, v0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    cmp-long v5, v9, v38

    if-gez v5, :cond_0

    .line 2023
    move-object/from16 v0, v36

    iget-wide v0, v0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    move-wide/from16 v38, v0

    .line 2028
    :cond_0
    move-object/from16 v0, v36

    iget-wide v9, v0, Lco/vine/android/api/VinePrivateMessage;->userId:J

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    move-object/from16 v0, v45

    invoke-virtual {v0, v5}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 2029
    move-object/from16 v0, v36

    iget-wide v9, v0, Lco/vine/android/api/VinePrivateMessage;->userId:J

    move-object/from16 v0, p0

    invoke-virtual {v0, v9, v10}, Lco/vine/android/provider/VineDatabaseHelper;->getUserRowIdForUserRemoteId(J)J

    move-result-wide v46

    .line 2030
    .local v46, "userRowId":J
    move-object/from16 v0, v36

    iget-wide v9, v0, Lco/vine/android/api/VinePrivateMessage;->userId:J

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-static/range {v46 .. v47}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    move-object/from16 v0, v45

    invoke-virtual {v0, v5, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2035
    :goto_1
    move-wide/from16 v0, v46

    move-object/from16 v2, v36

    iput-wide v0, v2, Lco/vine/android/api/VinePrivateMessage;->userId:J

    .line 2036
    move-object/from16 v0, v36

    iget-wide v9, v0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    move-object/from16 v0, v37

    move-object/from16 v1, v36

    invoke-virtual {v0, v5, v1}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 2011
    .end local v6    # "conversationId":J
    .end local v30    # "conversationRowId":J
    .end local v34    # "i$":Ljava/util/Iterator;
    .end local v36    # "message":Lco/vine/android/api/VinePrivateMessage;
    .end local v37    # "newMessages":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/Long;Lco/vine/android/api/VinePrivateMessage;>;"
    .end local v38    # "oldestMessageId":J
    .end local v44    # "updatedMessages":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/Long;Lco/vine/android/api/VinePrivateMessage;>;"
    .end local v45    # "userIdToUserRowMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Long;Ljava/lang/Long;>;"
    .end local v46    # "userRowId":J
    :catchall_0
    move-exception v5

    monitor-exit p0

    throw v5

    .line 2032
    .restart local v6    # "conversationId":J
    .restart local v30    # "conversationRowId":J
    .restart local v34    # "i$":Ljava/util/Iterator;
    .restart local v36    # "message":Lco/vine/android/api/VinePrivateMessage;
    .restart local v37    # "newMessages":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/Long;Lco/vine/android/api/VinePrivateMessage;>;"
    .restart local v38    # "oldestMessageId":J
    .restart local v44    # "updatedMessages":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/Long;Lco/vine/android/api/VinePrivateMessage;>;"
    .restart local v45    # "userIdToUserRowMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Long;Ljava/lang/Long;>;"
    :cond_1
    :try_start_1
    move-object/from16 v0, v36

    iget-wide v9, v0, Lco/vine/android/api/VinePrivateMessage;->userId:J

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    move-object/from16 v0, v45

    invoke-virtual {v0, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Long;

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v46

    .restart local v46    # "userRowId":J
    goto :goto_1

    .line 2040
    .end local v34    # "i$":Ljava/util/Iterator;
    .end local v36    # "message":Lco/vine/android/api/VinePrivateMessage;
    .end local v46    # "userRowId":J
    :cond_2
    sget-boolean v5, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v5, :cond_3

    .line 2041
    const-string v5, "VineDH"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "mergeMessages, count="

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual/range {v37 .. v37}, Ljava/util/LinkedHashMap;->size()I

    move-result v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v5, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 2044
    :cond_3
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v8

    .line 2046
    .local v8, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/16 v29, 0x1

    .line 2047
    .local v29, "contiguous":Z
    const-string v42, "conversation_row_id =? "

    .line 2048
    .local v42, "selectionString":Ljava/lang/String;
    const/4 v5, 0x1

    new-array v12, v5, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static/range {v30 .. v31}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v12, v5

    .line 2049
    .local v12, "selectionArgs":[Ljava/lang/String;
    const-string v9, "messages"

    sget-object v10, Lco/vine/android/provider/VineDatabaseSQL$MessagesQuery;->PROJECTION:[Ljava/lang/String;

    const-string v11, "conversation_row_id =? "

    const/4 v13, 0x0

    const/4 v14, 0x0

    const-string v15, "message_id DESC"

    const-string v16, "1"

    invoke-virtual/range {v8 .. v16}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v28

    .line 2052
    .local v28, "c":Landroid/database/Cursor;
    if-eqz v28, :cond_5

    .line 2053
    invoke-interface/range {v28 .. v28}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v5

    if-eqz v5, :cond_4

    .line 2054
    const/4 v5, 0x2

    move-object/from16 v0, v28

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v9

    cmp-long v5, v38, v9

    if-gtz v5, :cond_7

    const/16 v29, 0x1

    .line 2056
    :cond_4
    :goto_2
    invoke-interface/range {v28 .. v28}, Landroid/database/Cursor;->close()V

    .line 2059
    :cond_5
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v14, Lco/vine/android/provider/Vine$Messages;->CONTENT_URI:Landroid/net/Uri;

    sget-object v15, Lco/vine/android/provider/VineDatabaseSQL$MessagesQuery;->PROJECTION:[Ljava/lang/String;

    const/16 v16, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    invoke-virtual/range {v13 .. v18}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v32

    .line 2061
    .local v32, "cursor":Landroid/database/Cursor;
    if-eqz v32, :cond_9

    .line 2062
    :cond_6
    :goto_3
    invoke-interface/range {v32 .. v32}, Landroid/database/Cursor;->moveToNext()Z

    move-result v5

    if-eqz v5, :cond_8

    .line 2063
    const/4 v5, 0x2

    move-object/from16 v0, v32

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v9

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    move-object/from16 v0, v37

    invoke-virtual {v0, v5}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v36

    check-cast v36, Lco/vine/android/api/VinePrivateMessage;

    .line 2065
    .restart local v36    # "message":Lco/vine/android/api/VinePrivateMessage;
    if-eqz v36, :cond_6

    .line 2066
    move-object/from16 v0, v36

    iget-wide v9, v0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    move-object/from16 v0, v44

    move-object/from16 v1, v36

    invoke-virtual {v0, v5, v1}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_3

    .line 2054
    .end local v32    # "cursor":Landroid/database/Cursor;
    .end local v36    # "message":Lco/vine/android/api/VinePrivateMessage;
    :cond_7
    const/16 v29, 0x0

    goto :goto_2

    .line 2069
    .restart local v32    # "cursor":Landroid/database/Cursor;
    :cond_8
    invoke-interface/range {v32 .. v32}, Landroid/database/Cursor;->close()V

    .line 2072
    :cond_9
    const/16 v35, 0x0

    .line 2073
    .local v35, "inserted":I
    const/16 v43, 0x0

    .line 2075
    .local v43, "updated":I
    new-instance v40, Ljava/util/ArrayList;

    invoke-direct/range {v40 .. v40}, Ljava/util/ArrayList;-><init>()V

    .line 2077
    .local v40, "posts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    invoke-virtual/range {v37 .. v37}, Ljava/util/LinkedHashMap;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_f

    .line 2078
    sget-boolean v5, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v5, :cond_a

    .line 2079
    const-string v5, "VineDH"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Inserting new messages, count="

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual/range {v37 .. v37}, Ljava/util/LinkedHashMap;->size()I

    move-result v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v5, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 2082
    :cond_a
    invoke-virtual {v8}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2084
    :try_start_2
    new-instance v48, Landroid/content/ContentValues;

    invoke-direct/range {v48 .. v48}, Landroid/content/ContentValues;-><init>()V

    .line 2085
    .local v48, "values":Landroid/content/ContentValues;
    invoke-virtual/range {v37 .. v37}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v34

    .restart local v34    # "i$":Ljava/util/Iterator;
    :cond_b
    :goto_4
    invoke-interface/range {v34 .. v34}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_e

    invoke-interface/range {v34 .. v34}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v36

    check-cast v36, Lco/vine/android/api/VinePrivateMessage;

    .line 2086
    .restart local v36    # "message":Lco/vine/android/api/VinePrivateMessage;
    invoke-virtual/range {v48 .. v48}, Landroid/content/ContentValues;->clear()V

    .line 2088
    move-object/from16 v0, p0

    move-object/from16 v1, v48

    move-wide/from16 v2, v30

    move-object/from16 v4, v36

    invoke-direct {v0, v1, v2, v3, v4}, Lco/vine/android/provider/VineDatabaseHelper;->fillMessageValues(Landroid/content/ContentValues;JLco/vine/android/api/VinePrivateMessage;)V

    .line 2089
    const-string v5, "deleted"

    const/4 v9, 0x0

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    move-object/from16 v0, v48

    invoke-virtual {v0, v5, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2090
    const-string v5, "messages"

    const/4 v9, 0x0

    move-object/from16 v0, v48

    invoke-virtual {v8, v5, v9, v0}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v16

    .line 2091
    .local v16, "insertedRow":J
    const-wide/16 v9, 0x0

    cmp-long v5, v16, v9

    if-lez v5, :cond_d

    const/4 v5, 0x1

    :goto_5
    add-int v35, v35, v5

    .line 2092
    move-object/from16 v0, v36

    iget-wide v9, v0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    move-object/from16 v0, p3

    iget-wide v13, v0, Lco/vine/android/api/VineConversation;->lastMessage:J

    cmp-long v5, v9, v13

    if-nez v5, :cond_c

    .line 2093
    move-object/from16 v0, v36

    iget-wide v0, v0, Lco/vine/android/api/VinePrivateMessage;->created:J

    move-wide/from16 v18, v0

    move-object/from16 v13, p0

    move-wide/from16 v14, v30

    invoke-virtual/range {v13 .. v19}, Lco/vine/android/provider/VineDatabaseHelper;->updateConversationWithLastMessage(JJJ)V

    .line 2096
    :cond_c
    move-object/from16 v0, v36

    iget-object v5, v0, Lco/vine/android/api/VinePrivateMessage;->post:Lco/vine/android/api/VinePost;

    if-eqz v5, :cond_b

    .line 2097
    move-object/from16 v0, v36

    iget-object v5, v0, Lco/vine/android/api/VinePrivateMessage;->post:Lco/vine/android/api/VinePost;

    move-object/from16 v0, v40

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_4

    .line 2107
    .end local v16    # "insertedRow":J
    .end local v34    # "i$":Ljava/util/Iterator;
    .end local v36    # "message":Lco/vine/android/api/VinePrivateMessage;
    .end local v48    # "values":Landroid/content/ContentValues;
    :catchall_1
    move-exception v5

    :try_start_3
    move-object/from16 v0, p0

    invoke-virtual {v0, v8}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v5
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 2091
    .restart local v16    # "insertedRow":J
    .restart local v34    # "i$":Ljava/util/Iterator;
    .restart local v36    # "message":Lco/vine/android/api/VinePrivateMessage;
    .restart local v48    # "values":Landroid/content/ContentValues;
    :cond_d
    const/4 v5, 0x0

    goto :goto_5

    .line 2102
    .end local v16    # "insertedRow":J
    .end local v36    # "message":Lco/vine/android/api/VinePrivateMessage;
    :cond_e
    const/16 v20, 0xc

    :try_start_4
    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v21

    const/16 v22, 0x0

    const/16 v23, 0x0

    const/16 v24, 0x0

    const-wide/16 v25, 0x0

    const/16 v27, 0x1

    move-object/from16 v18, p0

    move-object/from16 v19, v40

    invoke-virtual/range {v18 .. v27}, Lco/vine/android/provider/VineDatabaseHelper;->mergePosts(Ljava/util/Collection;ILjava/lang/String;IIIJZ)Lco/vine/android/provider/DbResponse;

    .line 2105
    invoke-virtual {v8}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 2107
    :try_start_5
    move-object/from16 v0, p0

    invoke-virtual {v0, v8}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 2109
    const/4 v5, 0x0

    move-object/from16 v0, p0

    move-wide/from16 v1, v30

    invoke-virtual {v0, v1, v2, v5}, Lco/vine/android/provider/VineDatabaseHelper;->setConversationHidden(JZ)V

    .line 2112
    .end local v34    # "i$":Ljava/util/Iterator;
    .end local v48    # "values":Landroid/content/ContentValues;
    :cond_f
    invoke-virtual/range {v44 .. v44}, Ljava/util/LinkedHashMap;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_14

    .line 2113
    sget-boolean v5, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v5, :cond_10

    .line 2114
    const-string v5, "VineDH"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Updating existing messages, count="

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual/range {v44 .. v44}, Ljava/util/LinkedHashMap;->size()I

    move-result v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v5, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 2117
    :cond_10
    invoke-virtual {v8}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 2119
    :try_start_6
    new-instance v48, Landroid/content/ContentValues;

    invoke-direct/range {v48 .. v48}, Landroid/content/ContentValues;-><init>()V

    .line 2120
    .restart local v48    # "values":Landroid/content/ContentValues;
    invoke-virtual/range {v44 .. v44}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v34

    .restart local v34    # "i$":Ljava/util/Iterator;
    :cond_11
    :goto_6
    invoke-interface/range {v34 .. v34}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_13

    invoke-interface/range {v34 .. v34}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v36

    check-cast v36, Lco/vine/android/api/VinePrivateMessage;

    .line 2121
    .restart local v36    # "message":Lco/vine/android/api/VinePrivateMessage;
    invoke-virtual/range {v48 .. v48}, Landroid/content/ContentValues;->clear()V

    .line 2122
    move-object/from16 v0, p0

    move-object/from16 v1, v48

    move-wide/from16 v2, v30

    move-object/from16 v4, v36

    invoke-direct {v0, v1, v2, v3, v4}, Lco/vine/android/provider/VineDatabaseHelper;->fillMessageValues(Landroid/content/ContentValues;JLco/vine/android/api/VinePrivateMessage;)V

    .line 2123
    const-string v5, "messages"

    const-string v9, "message_id=?"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/String;

    const/4 v11, 0x0

    move-object/from16 v0, v36

    iget-wide v13, v0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    invoke-static {v13, v14}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v13

    aput-object v13, v10, v11

    move-object/from16 v0, v48

    invoke-virtual {v8, v5, v0, v9, v10}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v5

    if-lez v5, :cond_12

    const/4 v5, 0x1

    :goto_7
    add-int v43, v43, v5

    .line 2126
    move-object/from16 v0, v36

    iget-object v5, v0, Lco/vine/android/api/VinePrivateMessage;->post:Lco/vine/android/api/VinePost;

    if-eqz v5, :cond_11

    .line 2127
    move-object/from16 v0, v36

    iget-object v5, v0, Lco/vine/android/api/VinePrivateMessage;->post:Lco/vine/android/api/VinePost;

    move-object/from16 v0, v40

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    goto :goto_6

    .line 2136
    .end local v34    # "i$":Ljava/util/Iterator;
    .end local v36    # "message":Lco/vine/android/api/VinePrivateMessage;
    .end local v48    # "values":Landroid/content/ContentValues;
    :catchall_2
    move-exception v5

    :try_start_7
    move-object/from16 v0, p0

    invoke-virtual {v0, v8}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v5
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 2123
    .restart local v34    # "i$":Ljava/util/Iterator;
    .restart local v36    # "message":Lco/vine/android/api/VinePrivateMessage;
    .restart local v48    # "values":Landroid/content/ContentValues;
    :cond_12
    const/4 v5, 0x0

    goto :goto_7

    .line 2131
    .end local v36    # "message":Lco/vine/android/api/VinePrivateMessage;
    :cond_13
    const/16 v20, 0xc

    :try_start_8
    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v21

    const/16 v22, 0x0

    const/16 v23, 0x0

    const/16 v24, 0x0

    const-wide/16 v25, 0x0

    const/16 v27, 0x1

    move-object/from16 v18, p0

    move-object/from16 v19, v40

    invoke-virtual/range {v18 .. v27}, Lco/vine/android/provider/VineDatabaseHelper;->mergePosts(Ljava/util/Collection;ILjava/lang/String;IIIJZ)Lco/vine/android/provider/DbResponse;

    .line 2134
    invoke-virtual {v8}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_2

    .line 2136
    :try_start_9
    move-object/from16 v0, p0

    invoke-virtual {v0, v8}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 2139
    .end local v34    # "i$":Ljava/util/Iterator;
    .end local v48    # "values":Landroid/content/ContentValues;
    :cond_14
    const/16 v33, 0x0

    .line 2141
    .local v33, "deleted":I
    if-eqz v29, :cond_19

    .line 2142
    const/16 v41, 0x1

    .line 2151
    .local v41, "response":I
    :goto_8
    if-gtz p5, :cond_15

    if-gtz p6, :cond_15

    const-wide/16 v9, 0x0

    cmp-long v5, p7, v9

    if-lez v5, :cond_16

    .line 2152
    :cond_15
    const/16 v19, 0x7

    const/16 v20, 0x0

    invoke-static/range {v30 .. v31}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v21

    const/16 v26, 0x0

    move-object/from16 v18, p0

    move/from16 v22, p5

    move/from16 v23, p6

    move-wide/from16 v24, p7

    invoke-virtual/range {v18 .. v26}, Lco/vine/android/provider/VineDatabaseHelper;->savePageCursor(IILjava/lang/String;IIJZ)I

    .line 2156
    :cond_16
    if-gtz v35, :cond_17

    if-gtz v43, :cond_17

    if-lez v33, :cond_18

    .line 2157
    :cond_17
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v9, Lco/vine/android/provider/Vine$Messages;->CONTENT_URI:Landroid/net/Uri;

    const/4 v10, 0x0

    invoke-virtual {v5, v9, v10}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 2158
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v9, Lco/vine/android/provider/Vine$ConversationMessageUsersView;->CONTENT_URI:Landroid/net/Uri;

    const/4 v10, 0x0

    invoke-virtual {v5, v9, v10}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 2159
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v9, Lco/vine/android/provider/Vine$InboxView;->CONTENT_URI:Landroid/net/Uri;

    const/4 v10, 0x0

    invoke-virtual {v5, v9, v10}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 2161
    :cond_18
    monitor-exit p0

    return-wide v30

    .line 2144
    .end local v41    # "response":I
    :cond_19
    :try_start_a
    const-string v5, "Deleting messages for conversation row id {}, non contiguous"

    invoke-static/range {v30 .. v31}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    invoke-static {v5, v9}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 2145
    const-string v5, "messages"

    const-string v9, "conversation_row_id =? AND message_id <? AND message_id > ?"

    const/4 v10, 0x3

    new-array v10, v10, [Ljava/lang/String;

    const/4 v11, 0x0

    invoke-static/range {v30 .. v31}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v13

    aput-object v13, v10, v11

    const/4 v11, 0x1

    invoke-static/range {v38 .. v39}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v13

    aput-object v13, v10, v11

    const/4 v11, 0x2

    const-string v13, "0"

    aput-object v13, v10, v11

    invoke-virtual {v8, v5, v9, v10}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    move-result v33

    .line 2148
    const/16 v41, 0x4

    .restart local v41    # "response":I
    goto :goto_8
.end method

.method public declared-synchronized mergePosts(Ljava/util/Collection;ILjava/lang/String;IIIJZ)Lco/vine/android/provider/DbResponse;
    .locals 54
    .param p2, "groupType"    # I
    .param p3, "tag"    # Ljava/lang/String;
    .param p4, "pageType"    # I
    .param p5, "nextPage"    # I
    .param p6, "previousPage"    # I
    .param p7, "anchor"    # J
    .param p9, "userInitiated"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lco/vine/android/api/VinePost;",
            ">;I",
            "Ljava/lang/String;",
            "IIIJZ)",
            "Lco/vine/android/provider/DbResponse;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 221
    .local p1, "items":Ljava/util/Collection;, "Ljava/util/Collection<Lco/vine/android/api/VinePost;>;"
    monitor-enter p0

    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v5

    .line 222
    .local v5, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v35, Lco/vine/android/util/LongSparseArray;

    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->size()I

    move-result v6

    move-object/from16 v0, v35

    invoke-direct {v0, v6}, Lco/vine/android/util/LongSparseArray;-><init>(I)V

    .line 223
    .local v35, "newPosts":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VinePost;>;"
    new-instance v51, Lco/vine/android/util/LongSparseArray;

    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->size()I

    move-result v6

    move-object/from16 v0, v51

    invoke-direct {v0, v6}, Lco/vine/android/util/LongSparseArray;-><init>(I)V

    .line 225
    .local v51, "updatedPosts":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VinePost;>;"
    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v31

    .local v31, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface/range {v31 .. v31}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface/range {v31 .. v31}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v32

    check-cast v32, Lco/vine/android/api/VinePost;

    .line 226
    .local v32, "item":Lco/vine/android/api/VinePost;
    move-object/from16 v0, v32

    iget-wide v6, v0, Lco/vine/android/api/VinePost;->postId:J

    move-object/from16 v0, v35

    move-object/from16 v1, v32

    invoke-virtual {v0, v6, v7, v1}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 221
    .end local v5    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v31    # "i$":Ljava/util/Iterator;
    .end local v32    # "item":Lco/vine/android/api/VinePost;
    .end local v35    # "newPosts":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VinePost;>;"
    .end local v51    # "updatedPosts":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VinePost;>;"
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6

    .line 228
    .restart local v5    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v31    # "i$":Ljava/util/Iterator;
    .restart local v35    # "newPosts":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VinePost;>;"
    .restart local v51    # "updatedPosts":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VinePost;>;"
    :cond_0
    :try_start_1
    invoke-static/range {p2 .. p2}, Lco/vine/android/util/Util;->isPopularTimeline(I)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 229
    new-instance v41, Lco/vine/android/util/LongSparseArray;

    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->size()I

    move-result v6

    move-object/from16 v0, v41

    invoke-direct {v0, v6}, Lco/vine/android/util/LongSparseArray;-><init>(I)V

    .line 231
    .local v41, "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    const/4 v6, 0x1

    move/from16 v0, p4

    if-eq v0, v6, :cond_1

    const/4 v6, 0x2

    move/from16 v0, p4

    if-ne v0, v6, :cond_2

    .line 232
    :cond_1
    const/16 v47, 0x1

    .line 233
    .local v47, "sortId":I
    move-object/from16 v0, p0

    move/from16 v1, p2

    invoke-direct {v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->removePostsFromGroup(I)I

    .line 243
    :goto_1
    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v31

    :goto_2
    invoke-interface/range {v31 .. v31}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_5

    invoke-interface/range {v31 .. v31}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v32

    check-cast v32, Lco/vine/android/api/VinePost;

    .line 244
    .restart local v32    # "item":Lco/vine/android/api/VinePost;
    move-object/from16 v0, v32

    iget-wide v6, v0, Lco/vine/android/api/VinePost;->postId:J

    move/from16 v0, v47

    int-to-long v12, v0

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    move-object/from16 v0, v41

    invoke-virtual {v0, v6, v7, v10}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 245
    add-int/lit8 v47, v47, 0x1

    .line 246
    goto :goto_2

    .line 235
    .end local v32    # "item":Lco/vine/android/api/VinePost;
    .end local v47    # "sortId":I
    :cond_2
    move-object/from16 v0, p0

    move/from16 v1, p2

    invoke-virtual {v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getOldestSortId(I)Landroid/database/Cursor;

    move-result-object v26

    .line 236
    .local v26, "c":Landroid/database/Cursor;
    if-eqz v26, :cond_3

    invoke-interface/range {v26 .. v26}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 237
    const/4 v6, 0x0

    move-object/from16 v0, v26

    invoke-interface {v0, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v47

    .line 238
    .restart local v47    # "sortId":I
    add-int/lit8 v47, v47, 0x1

    goto :goto_1

    .line 240
    .end local v47    # "sortId":I
    :cond_3
    const/16 v47, 0x1

    .restart local v47    # "sortId":I
    goto :goto_1

    .line 248
    .end local v26    # "c":Landroid/database/Cursor;
    .end local v41    # "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    .end local v47    # "sortId":I
    :cond_4
    new-instance v41, Lco/vine/android/util/LongSparseArray;

    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->size()I

    move-result v6

    move-object/from16 v0, v41

    invoke-direct {v0, v6}, Lco/vine/android/util/LongSparseArray;-><init>(I)V

    .line 249
    .restart local v41    # "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v31

    :goto_3
    invoke-interface/range {v31 .. v31}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_5

    invoke-interface/range {v31 .. v31}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v32

    check-cast v32, Lco/vine/android/api/VinePost;

    .line 250
    .restart local v32    # "item":Lco/vine/android/api/VinePost;
    move-object/from16 v0, v32

    iget-wide v6, v0, Lco/vine/android/api/VinePost;->postId:J

    invoke-static/range {p2 .. p2}, Lco/vine/android/api/VineComparatorFactory;->get(I)Lco/vine/android/api/VineComparatorFactory$VineComparator;

    move-result-object v10

    move-object/from16 v0, v32

    invoke-interface {v10, v0}, Lco/vine/android/api/VineComparatorFactory$VineComparator;->getOrderId(Ljava/lang/Object;)J

    move-result-wide v12

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    move-object/from16 v0, v41

    invoke-virtual {v0, v6, v7, v10}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V

    goto :goto_3

    .line 255
    .end local v32    # "item":Lco/vine/android/api/VinePost;
    :cond_5
    const/16 v27, 0x1

    .line 259
    .local v27, "contiguous":Z
    invoke-static/range {p3 .. p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_c

    invoke-static/range {p2 .. p2}, Lco/vine/android/util/Util;->isPopularTimeline(I)Z

    move-result v6

    if-nez v6, :cond_c

    .line 260
    const-string v8, "post_type=? AND tag=?"

    .line 261
    .local v8, "selectionString":Ljava/lang/String;
    const/4 v6, 0x2

    new-array v9, v6, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static/range {p2 .. p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v9, v6

    const/4 v6, 0x1

    aput-object p3, v9, v6

    .line 266
    .local v9, "selectionArgs":[Ljava/lang/String;
    :goto_4
    const-string v6, "post_groups_view"

    sget-object v7, Lco/vine/android/provider/VineDatabaseSQL$PostGroupsQuery;->PROJECTION:[Ljava/lang/String;

    const/4 v10, 0x0

    const/4 v11, 0x0

    const-string v12, "sort_id DESC"

    invoke-virtual/range {v5 .. v12}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v26

    .line 269
    .restart local v26    # "c":Landroid/database/Cursor;
    if-eqz v26, :cond_7

    .line 271
    :try_start_2
    invoke-interface/range {v26 .. v26}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v6

    if-eqz v6, :cond_6

    .line 273
    const-wide/16 v6, 0x0

    cmp-long v6, p7, v6

    if-lez v6, :cond_6

    .line 274
    const/4 v6, 0x3

    move-object/from16 v0, v26

    invoke-interface {v0, v6}, Landroid/database/Cursor;->getLong(I)J
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-wide v6

    cmp-long v6, p7, v6

    if-gez v6, :cond_d

    const/16 v27, 0x1

    .line 278
    :cond_6
    :goto_5
    :try_start_3
    invoke-interface/range {v26 .. v26}, Landroid/database/Cursor;->close()V

    .line 283
    :cond_7
    const-string v11, "posts"

    const/4 v6, 0x1

    new-array v12, v6, [Ljava/lang/String;

    const/4 v6, 0x0

    const-string v7, "post_id"

    aput-object v7, v12, v6

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    move-object v10, v5

    invoke-virtual/range {v10 .. v17}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v26

    .line 285
    if-eqz v26, :cond_b

    .line 287
    :try_start_4
    invoke-interface/range {v26 .. v26}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v6

    if-eqz v6, :cond_a

    .line 289
    :cond_8
    const/4 v6, 0x0

    move-object/from16 v0, v26

    invoke-interface {v0, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v43

    .line 290
    .local v43, "postId":J
    move-object/from16 v0, v35

    move-wide/from16 v1, v43

    invoke-virtual {v0, v1, v2}, Lco/vine/android/util/LongSparseArray;->removeKey(J)Ljava/lang/Object;

    move-result-object v42

    check-cast v42, Lco/vine/android/api/VinePost;

    .line 291
    .local v42, "post":Lco/vine/android/api/VinePost;
    if-eqz v42, :cond_9

    .line 292
    move-object/from16 v0, v51

    move-wide/from16 v1, v43

    move-object/from16 v3, v42

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 294
    :cond_9
    invoke-interface/range {v26 .. v26}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    move-result v6

    if-nez v6, :cond_8

    .line 297
    .end local v42    # "post":Lco/vine/android/api/VinePost;
    .end local v43    # "postId":J
    :cond_a
    :try_start_5
    invoke-interface/range {v26 .. v26}, Landroid/database/Cursor;->close()V

    .line 301
    :cond_b
    sget-boolean v6, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v6, :cond_e

    invoke-virtual/range {v35 .. v35}, Lco/vine/android/util/LongSparseArray;->isEmpty()Z

    move-result v6

    if-eqz v6, :cond_e

    invoke-virtual/range {v51 .. v51}, Lco/vine/android/util/LongSparseArray;->isEmpty()Z

    move-result v6

    if-eqz v6, :cond_e

    .line 302
    const-string v6, "VineDH"

    const-string v7, "No new posts to merge or update"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 303
    new-instance v6, Lco/vine/android/provider/DbResponse;

    const/4 v7, 0x0

    const/4 v10, 0x0

    const/4 v12, 0x2

    invoke-direct {v6, v7, v10, v12}, Lco/vine/android/provider/DbResponse;-><init>(III)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 487
    :goto_6
    monitor-exit p0

    return-object v6

    .line 263
    .end local v8    # "selectionString":Ljava/lang/String;
    .end local v9    # "selectionArgs":[Ljava/lang/String;
    .end local v26    # "c":Landroid/database/Cursor;
    :cond_c
    :try_start_6
    const-string v8, "post_type=?"

    .line 264
    .restart local v8    # "selectionString":Ljava/lang/String;
    const/4 v6, 0x1

    new-array v9, v6, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static/range {p2 .. p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v9, v6

    .restart local v9    # "selectionArgs":[Ljava/lang/String;
    goto/16 :goto_4

    .line 274
    .restart local v26    # "c":Landroid/database/Cursor;
    :cond_d
    const/16 v27, 0x0

    goto :goto_5

    .line 278
    :catchall_1
    move-exception v6

    invoke-interface/range {v26 .. v26}, Landroid/database/Cursor;->close()V

    throw v6

    .line 297
    :catchall_2
    move-exception v6

    invoke-interface/range {v26 .. v26}, Landroid/database/Cursor;->close()V

    throw v6

    .line 306
    :cond_e
    new-instance v16, Lco/vine/android/util/LongSparseArray;

    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->size()I

    move-result v6

    move-object/from16 v0, v16

    invoke-direct {v0, v6}, Lco/vine/android/util/LongSparseArray;-><init>(I)V

    .line 307
    .local v16, "tagMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    new-instance v11, Ljava/util/ArrayList;

    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->size()I

    move-result v6

    invoke-direct {v11, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 309
    .local v11, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    invoke-virtual/range {v35 .. v35}, Lco/vine/android/util/LongSparseArray;->size()I

    move-result v46

    .line 310
    .local v46, "size":I
    const/16 v30, 0x0

    .local v30, "i":I
    :goto_7
    move/from16 v0, v30

    move/from16 v1, v46

    if-ge v0, v1, :cond_10

    .line 311
    move-object/from16 v0, v35

    move/from16 v1, v30

    invoke-virtual {v0, v1}, Lco/vine/android/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v53

    check-cast v53, Lco/vine/android/api/VinePost;

    .line 312
    .local v53, "vc":Lco/vine/android/api/VinePost;
    move-object/from16 v0, v53

    iget-object v6, v0, Lco/vine/android/api/VinePost;->user:Lco/vine/android/api/VineUser;

    if-eqz v6, :cond_f

    .line 313
    move-object/from16 v0, v53

    iget-object v6, v0, Lco/vine/android/api/VinePost;->user:Lco/vine/android/api/VineUser;

    invoke-virtual {v11, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 314
    move-object/from16 v0, v53

    iget-wide v6, v0, Lco/vine/android/api/VinePost;->userId:J

    move-object/from16 v0, v53

    iget-wide v12, v0, Lco/vine/android/api/VinePost;->postId:J

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    move-object/from16 v0, v16

    invoke-virtual {v0, v6, v7, v10}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 310
    :cond_f
    add-int/lit8 v30, v30, 0x1

    goto :goto_7

    .line 318
    .end local v53    # "vc":Lco/vine/android/api/VinePost;
    :cond_10
    const/4 v12, 0x4

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v17, 0x0

    move-object/from16 v10, p0

    invoke-virtual/range {v10 .. v17}, Lco/vine/android/provider/VineDatabaseHelper;->mergeUsers(Ljava/util/Collection;ILjava/lang/String;IILco/vine/android/util/LongSparseArray;Lco/vine/android/util/LongSparseArray;)I

    .line 320
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v33

    .line 322
    .local v33, "lastRefresh":J
    const/16 v36, 0x0

    .line 324
    .local v36, "numInserted":I
    invoke-virtual/range {v35 .. v35}, Lco/vine/android/util/LongSparseArray;->size()I

    move-result v46

    .line 326
    if-lez v46, :cond_16

    .line 327
    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 329
    :try_start_7
    new-instance v52, Landroid/content/ContentValues;

    invoke-direct/range {v52 .. v52}, Landroid/content/ContentValues;-><init>()V

    .line 330
    .local v52, "values":Landroid/content/ContentValues;
    const/16 v30, 0x0

    :goto_8
    move/from16 v0, v30

    move/from16 v1, v46

    if-ge v0, v1, :cond_15

    .line 331
    move-object/from16 v0, v35

    move/from16 v1, v30

    invoke-virtual {v0, v1}, Lco/vine/android/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v42

    check-cast v42, Lco/vine/android/api/VinePost;

    .line 333
    .restart local v42    # "post":Lco/vine/android/api/VinePost;
    invoke-virtual/range {v52 .. v52}, Landroid/content/ContentValues;->clear()V

    .line 336
    move-object/from16 v0, v42

    iget-object v6, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    if-eqz v6, :cond_12

    move-object/from16 v0, v42

    iget-object v6, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    iget v6, v6, Lco/vine/android/api/VinePagedData;->count:I

    :goto_9
    move-object/from16 v0, v42

    iput v6, v0, Lco/vine/android/api/VinePost;->likesCount:I

    .line 337
    move-object/from16 v0, v42

    iget-object v6, v0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    if-eqz v6, :cond_13

    move-object/from16 v0, v42

    iget-object v6, v0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    iget v6, v6, Lco/vine/android/api/VinePagedData;->count:I

    :goto_a
    move-object/from16 v0, v42

    iput v6, v0, Lco/vine/android/api/VinePost;->commentsCount:I

    .line 339
    move-object/from16 v0, p0

    move-object/from16 v1, v52

    move-object/from16 v2, v42

    move-wide/from16 v3, v33

    invoke-direct {v0, v1, v2, v3, v4}, Lco/vine/android/provider/VineDatabaseHelper;->fillPostValues(Landroid/content/ContentValues;Lco/vine/android/api/VinePost;J)V

    .line 340
    const-string v6, "posts"

    const/4 v7, 0x0

    move-object/from16 v0, v52

    invoke-virtual {v5, v6, v7, v0}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v6

    const-wide/16 v12, 0x0

    cmp-long v6, v6, v12

    if-lez v6, :cond_14

    const/4 v6, 0x1

    :goto_b
    add-int v36, v36, v6

    .line 341
    move-object/from16 v0, v42

    iget-object v6, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    if-eqz v6, :cond_11

    move-object/from16 v0, v42

    iget-object v6, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    iget-object v6, v6, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    if-eqz v6, :cond_11

    move-object/from16 v0, v42

    iget-object v6, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    iget-object v6, v6, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_11

    .line 342
    move-object/from16 v0, v42

    iget-object v6, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    iget-object v0, v6, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v18, v0

    move-object/from16 v0, v42

    iget-wide v0, v0, Lco/vine/android/api/VinePost;->postId:J

    move-wide/from16 v19, v0

    const/16 v21, -0x1

    const/16 v22, -0x1

    move-object/from16 v17, p0

    invoke-virtual/range {v17 .. v22}, Lco/vine/android/provider/VineDatabaseHelper;->mergeLikes(Ljava/util/Collection;JII)I

    .line 330
    :cond_11
    add-int/lit8 v30, v30, 0x1

    goto/16 :goto_8

    .line 336
    :cond_12
    const/4 v6, 0x0

    goto :goto_9

    .line 337
    :cond_13
    const/4 v6, 0x0

    goto :goto_a

    .line 340
    :cond_14
    const/4 v6, 0x0

    goto :goto_b

    .line 345
    .end local v42    # "post":Lco/vine/android/api/VinePost;
    :cond_15
    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_3

    .line 347
    :try_start_8
    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 351
    .end local v52    # "values":Landroid/content/ContentValues;
    :cond_16
    const/16 v37, 0x0

    .line 353
    .local v37, "numUpdated":I
    invoke-virtual/range {v51 .. v51}, Lco/vine/android/util/LongSparseArray;->size()I

    move-result v46

    .line 354
    if-lez v46, :cond_1c

    .line 355
    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 357
    :try_start_9
    new-instance v52, Landroid/content/ContentValues;

    invoke-direct/range {v52 .. v52}, Landroid/content/ContentValues;-><init>()V

    .line 358
    .restart local v52    # "values":Landroid/content/ContentValues;
    const/16 v30, 0x0

    :goto_c
    move/from16 v0, v30

    move/from16 v1, v46

    if-ge v0, v1, :cond_1b

    .line 359
    move-object/from16 v0, v51

    move/from16 v1, v30

    invoke-virtual {v0, v1}, Lco/vine/android/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v42

    check-cast v42, Lco/vine/android/api/VinePost;

    .line 361
    .restart local v42    # "post":Lco/vine/android/api/VinePost;
    invoke-virtual/range {v52 .. v52}, Landroid/content/ContentValues;->clear()V

    .line 363
    move-object/from16 v0, v42

    iget-object v6, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    if-eqz v6, :cond_18

    move-object/from16 v0, v42

    iget-object v6, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    iget v6, v6, Lco/vine/android/api/VinePagedData;->count:I

    :goto_d
    move-object/from16 v0, v42

    iput v6, v0, Lco/vine/android/api/VinePost;->likesCount:I

    .line 364
    move-object/from16 v0, v42

    iget-object v6, v0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    if-eqz v6, :cond_19

    move-object/from16 v0, v42

    iget-object v6, v0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    iget v6, v6, Lco/vine/android/api/VinePagedData;->count:I

    :goto_e
    move-object/from16 v0, v42

    iput v6, v0, Lco/vine/android/api/VinePost;->commentsCount:I

    .line 366
    move-object/from16 v0, p0

    move-object/from16 v1, v52

    move-object/from16 v2, v42

    move-wide/from16 v3, v33

    invoke-direct {v0, v1, v2, v3, v4}, Lco/vine/android/provider/VineDatabaseHelper;->fillPostValues(Landroid/content/ContentValues;Lco/vine/android/api/VinePost;J)V

    .line 367
    const-string v6, "posts"

    const-string v7, "post_id=?"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/String;

    const/4 v12, 0x0

    move-object/from16 v0, v42

    iget-wide v13, v0, Lco/vine/android/api/VinePost;->postId:J

    invoke-static {v13, v14}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v13

    aput-object v13, v10, v12

    move-object/from16 v0, v52

    invoke-virtual {v5, v6, v0, v7, v10}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v6

    if-lez v6, :cond_1a

    const/4 v6, 0x1

    :goto_f
    add-int v37, v37, v6

    .line 369
    move-object/from16 v0, v42

    iget-object v6, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    if-eqz v6, :cond_17

    move-object/from16 v0, v42

    iget-object v6, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    iget-object v6, v6, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    if-eqz v6, :cond_17

    move-object/from16 v0, v42

    iget-object v6, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    iget-object v6, v6, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_17

    .line 370
    move-object/from16 v0, v42

    iget-object v6, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    iget-object v0, v6, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v18, v0

    move-object/from16 v0, v42

    iget-wide v0, v0, Lco/vine/android/api/VinePost;->postId:J

    move-wide/from16 v19, v0

    const/16 v21, -0x1

    const/16 v22, -0x1

    move-object/from16 v17, p0

    invoke-virtual/range {v17 .. v22}, Lco/vine/android/provider/VineDatabaseHelper;->mergeLikes(Ljava/util/Collection;JII)I
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_4

    .line 358
    :cond_17
    add-int/lit8 v30, v30, 0x1

    goto/16 :goto_c

    .line 347
    .end local v37    # "numUpdated":I
    .end local v42    # "post":Lco/vine/android/api/VinePost;
    .end local v52    # "values":Landroid/content/ContentValues;
    :catchall_3
    move-exception v6

    :try_start_a
    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v6
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    .line 363
    .restart local v37    # "numUpdated":I
    .restart local v42    # "post":Lco/vine/android/api/VinePost;
    .restart local v52    # "values":Landroid/content/ContentValues;
    :cond_18
    const/4 v6, 0x0

    goto :goto_d

    .line 364
    :cond_19
    const/4 v6, 0x0

    goto :goto_e

    .line 367
    :cond_1a
    const/4 v6, 0x0

    goto :goto_f

    .line 373
    .end local v42    # "post":Lco/vine/android/api/VinePost;
    :cond_1b
    :try_start_b
    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_4

    .line 375
    :try_start_c
    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 379
    .end local v52    # "values":Landroid/content/ContentValues;
    :cond_1c
    sget-boolean v6, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v6, :cond_1d

    .line 380
    const-string v6, "VineDH"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Inserted "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move/from16 v0, v36

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, " posts, and updated "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move/from16 v0, v37

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, " with lastRefresh time "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move-wide/from16 v0, v33

    invoke-virtual {v7, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 384
    :cond_1d
    const-wide/16 v6, 0x0

    cmp-long v6, p7, v6

    if-gtz v6, :cond_1e

    if-gtz p5, :cond_1e

    if-lez p6, :cond_1f

    .line 385
    :cond_1e
    const/16 v18, 0x2

    const/16 v25, 0x0

    move-object/from16 v17, p0

    move/from16 v19, p2

    move-object/from16 v20, p3

    move/from16 v21, p5

    move/from16 v22, p6

    move-wide/from16 v23, p7

    invoke-virtual/range {v17 .. v25}, Lco/vine/android/provider/VineDatabaseHelper;->savePageCursor(IILjava/lang/String;IIJZ)I

    .line 391
    :cond_1f
    if-eqz v27, :cond_27

    .line 392
    const/16 v45, 0x1

    .line 423
    .local v45, "response":I
    :goto_10
    const/16 v28, 0x0

    .line 424
    .local v28, "deleted":I
    if-lez v36, :cond_23

    if-eqz v27, :cond_23

    .line 425
    const-string v18, "posts"

    sget-object v19, Lco/vine/android/provider/VineDatabaseSQL$TableQuery;->PROJECTION:[Ljava/lang/String;

    const/16 v20, 0x0

    const/16 v21, 0x0

    const/16 v22, 0x0

    const/16 v23, 0x0

    const/16 v24, 0x0

    move-object/from16 v17, v5

    invoke-virtual/range {v17 .. v24}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_0

    move-result-object v48

    .line 427
    .local v48, "tableCursor":Landroid/database/Cursor;
    if-eqz v48, :cond_23

    .line 429
    :try_start_d
    invoke-interface/range {v48 .. v48}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v6

    if-eqz v6, :cond_22

    .line 430
    invoke-interface/range {v48 .. v48}, Landroid/database/Cursor;->getCount()I
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_7

    move-result v46

    .line 431
    const/16 v6, 0x3e8

    move/from16 v0, v46

    if-le v0, v6, :cond_22

    .line 433
    :try_start_e
    const-string v6, "SELECT last_refresh FROM posts ORDER BY last_refresh DESC LIMIT 1 OFFSET 500"

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v40

    .line 439
    .local v40, "oldestNthRow":Landroid/database/Cursor;
    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_6

    .line 440
    if-eqz v40, :cond_21

    .line 442
    :try_start_f
    invoke-interface/range {v40 .. v40}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v6

    if-eqz v6, :cond_20

    .line 443
    const/4 v6, 0x0

    move-object/from16 v0, v40

    invoke-interface {v0, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v38

    .line 445
    .local v38, "oldestNthId":J
    const-string v6, "DELETE FROM post_groups WHERE post_id IN (SELECT post_id FROM posts WHERE last_refresh < ?);"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/String;

    const/4 v10, 0x0

    invoke-static/range {v38 .. v39}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v12

    aput-object v12, v7, v10

    invoke-virtual {v5, v6, v7}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 451
    const-string v6, "posts"

    const-string v7, "last_refresh<?"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/String;

    const/4 v12, 0x0

    invoke-static/range {v38 .. v39}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v13

    aput-object v13, v10, v12

    invoke-virtual {v5, v6, v7, v10}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v28

    .line 454
    sget-boolean v6, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v6, :cond_20

    .line 455
    const-string v6, "s"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Due to reaching maximum table size ("

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move/from16 v0, v46

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, " with a max of "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const/16 v10, 0x3e8

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, "), deleted "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move/from16 v0, v28

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, " posts groups all less than last refresh id "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move-wide/from16 v0, v38

    invoke-virtual {v7, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, "."

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_f
    .catchall {:try_start_f .. :try_end_f} :catchall_5

    .line 462
    .end local v38    # "oldestNthId":J
    :cond_20
    :try_start_10
    invoke-interface/range {v40 .. v40}, Landroid/database/Cursor;->close()V

    .line 465
    :cond_21
    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_10
    .catchall {:try_start_10 .. :try_end_10} :catchall_6

    .line 467
    :try_start_11
    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_11
    .catchall {:try_start_11 .. :try_end_11} :catchall_7

    .line 472
    .end local v40    # "oldestNthRow":Landroid/database/Cursor;
    :cond_22
    :try_start_12
    invoke-interface/range {v48 .. v48}, Landroid/database/Cursor;->close()V

    .line 478
    .end local v48    # "tableCursor":Landroid/database/Cursor;
    :cond_23
    if-gtz v36, :cond_24

    if-gtz v37, :cond_24

    if-lez v28, :cond_26

    :cond_24
    if-eqz p2, :cond_26

    .line 480
    const/4 v6, -0x1

    move/from16 v0, p2

    if-eq v0, v6, :cond_25

    .line 481
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, p2

    move-object/from16 v3, p3

    move-object/from16 v4, v41

    invoke-direct {v0, v1, v2, v3, v4}, Lco/vine/android/provider/VineDatabaseHelper;->mergePostGroups(Ljava/util/Collection;ILjava/lang/String;Lco/vine/android/util/LongSparseArray;)V

    .line 483
    :cond_25
    if-eqz p9, :cond_26

    .line 484
    move-object/from16 v0, p0

    move/from16 v1, p2

    invoke-direct {v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->notifyByType(I)V

    .line 487
    :cond_26
    new-instance v6, Lco/vine/android/provider/DbResponse;

    move/from16 v0, v36

    move/from16 v1, v37

    move/from16 v2, v45

    invoke-direct {v6, v0, v1, v2}, Lco/vine/android/provider/DbResponse;-><init>(III)V

    goto/16 :goto_6

    .line 375
    .end local v28    # "deleted":I
    .end local v45    # "response":I
    :catchall_4
    move-exception v6

    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v6

    .line 397
    :cond_27
    invoke-static/range {p3 .. p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_29

    .line 398
    const-string v49, "post_type=? AND tag=? AND post_id<?"

    .line 400
    .local v49, "timelineSelection":Ljava/lang/String;
    const/4 v6, 0x3

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v50, v0

    const/4 v6, 0x0

    invoke-static/range {p2 .. p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v50, v6

    const/4 v6, 0x1

    aput-object p3, v50, v6

    const/4 v6, 0x2

    invoke-static/range {p7 .. p8}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v50, v6

    .line 408
    .local v50, "timelineSelectionArgs":[Ljava/lang/String;
    :goto_11
    const-string v6, "posts"

    const-string v7, "post_id<?"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/String;

    const/4 v12, 0x0

    invoke-static/range {p2 .. p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v13

    aput-object v13, v10, v12

    invoke-virtual {v5, v6, v7, v10}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v28

    .line 410
    .restart local v28    # "deleted":I
    const-string v6, "post_groups"

    move-object/from16 v0, v49

    move-object/from16 v1, v50

    invoke-virtual {v5, v6, v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v29

    .line 412
    .local v29, "deletedGroups":I
    sget-boolean v6, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v6, :cond_28

    .line 413
    const-string v6, "VineDH"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Non contiguous timeline detected, deleted "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move/from16 v0, v28

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, " posts and "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move/from16 v0, v29

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, " with id less than anchor: "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move-wide/from16 v0, p7

    invoke-virtual {v7, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, " of type "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move/from16 v0, p2

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, " and tag "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move-object/from16 v0, p3

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 417
    :cond_28
    const/16 v45, 0x4

    .restart local v45    # "response":I
    goto/16 :goto_10

    .line 403
    .end local v28    # "deleted":I
    .end local v29    # "deletedGroups":I
    .end local v45    # "response":I
    .end local v49    # "timelineSelection":Ljava/lang/String;
    .end local v50    # "timelineSelectionArgs":[Ljava/lang/String;
    :cond_29
    const-string v49, "post_type=? AND post_id<?"

    .line 404
    .restart local v49    # "timelineSelection":Ljava/lang/String;
    const/4 v6, 0x2

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v50, v0

    const/4 v6, 0x0

    invoke-static/range {p2 .. p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v50, v6

    const/4 v6, 0x1

    invoke-static/range {p7 .. p8}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v50, v6
    :try_end_12
    .catchall {:try_start_12 .. :try_end_12} :catchall_0

    .restart local v50    # "timelineSelectionArgs":[Ljava/lang/String;
    goto/16 :goto_11

    .line 462
    .end local v49    # "timelineSelection":Ljava/lang/String;
    .end local v50    # "timelineSelectionArgs":[Ljava/lang/String;
    .restart local v28    # "deleted":I
    .restart local v40    # "oldestNthRow":Landroid/database/Cursor;
    .restart local v45    # "response":I
    .restart local v48    # "tableCursor":Landroid/database/Cursor;
    :catchall_5
    move-exception v6

    :try_start_13
    invoke-interface/range {v40 .. v40}, Landroid/database/Cursor;->close()V

    throw v6
    :try_end_13
    .catchall {:try_start_13 .. :try_end_13} :catchall_6

    .line 467
    .end local v40    # "oldestNthRow":Landroid/database/Cursor;
    :catchall_6
    move-exception v6

    :try_start_14
    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v6
    :try_end_14
    .catchall {:try_start_14 .. :try_end_14} :catchall_7

    .line 472
    :catchall_7
    move-exception v6

    :try_start_15
    invoke-interface/range {v48 .. v48}, Landroid/database/Cursor;->close()V

    throw v6
    :try_end_15
    .catchall {:try_start_15 .. :try_end_15} :catchall_0
.end method

.method public declared-synchronized mergePushNotification(Lco/vine/android/api/VineSingleNotification;Ljava/lang/String;I)Ljava/util/ArrayList;
    .locals 14
    .param p1, "notification"    # Lco/vine/android/api/VineSingleNotification;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "notificationType"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lco/vine/android/api/VineSingleNotification;",
            "Ljava/lang/String;",
            "I)",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineSingleNotification;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1090
    monitor-enter p0

    const/16 v2, 0x12

    move/from16 v0, p3

    if-ne v0, v2, :cond_3

    const/4 v11, 0x1

    .line 1092
    .local v11, "isPrivateMessage":Z
    :goto_0
    if-eqz v11, :cond_0

    .line 1093
    :try_start_0
    iget-object v0, p1, Lco/vine/android/api/VineSingleNotification;->comment:Ljava/lang/String;

    move-object/from16 p2, v0

    .line 1096
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 1098
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v12, 0x0

    .line 1100
    .local v12, "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "notification_id=?"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    if-eqz v11, :cond_4

    const-string v2, " AND notification_type=?"

    :goto_1
    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 1101
    .local v4, "selection":Ljava/lang/String;
    if-eqz v11, :cond_5

    const/4 v2, 0x2

    new-array v5, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    iget-wide v6, p1, Lco/vine/android/api/VineSingleNotification;->notificationId:J

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v5, v2

    const/4 v2, 0x1

    invoke-static/range {p3 .. p3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v5, v2

    .line 1104
    .local v5, "whereArgs":[Ljava/lang/String;
    :goto_2
    const-string v2, "notifications"

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$NotificationsQuery;->PROJECTION:[Ljava/lang/String;

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "notification_id DESC"

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v9

    .line 1107
    .local v9, "c":Landroid/database/Cursor;
    const/4 v10, 0x0

    .line 1109
    .local v10, "inserted":I
    :try_start_1
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    .line 1111
    if-eqz v9, :cond_2

    .line 1113
    :try_start_2
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-nez v2, :cond_1

    .line 1114
    new-instance v13, Landroid/content/ContentValues;

    invoke-direct {v13}, Landroid/content/ContentValues;-><init>()V

    .line 1115
    .local v13, "values":Landroid/content/ContentValues;
    move-object/from16 v0, p2

    invoke-direct {p0, v13, p1, v0}, Lco/vine/android/provider/VineDatabaseHelper;->fillNotificationValues(Landroid/content/ContentValues;Lco/vine/android/api/VineSingleNotification;Ljava/lang/String;)V

    .line 1116
    const-string v2, "notifications"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v13}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v2

    const-wide/16 v6, 0x0

    cmp-long v2, v2, v6

    if-lez v2, :cond_6

    const/4 v2, 0x1

    :goto_3
    add-int/2addr v10, v2

    .line 1117
    if-lez v10, :cond_1

    .line 1118
    move/from16 v0, p3

    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->getNotifications(I)Ljava/util/ArrayList;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v12

    .line 1122
    .end local v13    # "values":Landroid/content/ContentValues;
    :cond_1
    :try_start_3
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 1125
    :cond_2
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 1127
    :try_start_4
    invoke-virtual {p0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 1129
    monitor-exit p0

    return-object v12

    .line 1090
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v4    # "selection":Ljava/lang/String;
    .end local v5    # "whereArgs":[Ljava/lang/String;
    .end local v9    # "c":Landroid/database/Cursor;
    .end local v10    # "inserted":I
    .end local v11    # "isPrivateMessage":Z
    .end local v12    # "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    :cond_3
    const/4 v11, 0x0

    goto :goto_0

    .line 1100
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v11    # "isPrivateMessage":Z
    .restart local v12    # "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    :cond_4
    :try_start_5
    const-string v2, ""

    goto :goto_1

    .line 1101
    .restart local v4    # "selection":Ljava/lang/String;
    :cond_5
    const/4 v2, 0x1

    new-array v5, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    iget-wide v6, p1, Lco/vine/android/api/VineSingleNotification;->notificationId:J

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v5, v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_2

    .line 1090
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v4    # "selection":Ljava/lang/String;
    .end local v12    # "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 1116
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v4    # "selection":Ljava/lang/String;
    .restart local v5    # "whereArgs":[Ljava/lang/String;
    .restart local v9    # "c":Landroid/database/Cursor;
    .restart local v10    # "inserted":I
    .restart local v12    # "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    .restart local v13    # "values":Landroid/content/ContentValues;
    :cond_6
    const/4 v2, 0x0

    goto :goto_3

    .line 1122
    .end local v13    # "values":Landroid/content/ContentValues;
    :catchall_1
    move-exception v2

    :try_start_6
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    throw v2
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    .line 1127
    :catchall_2
    move-exception v2

    :try_start_7
    invoke-virtual {p0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v2
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0
.end method

.method public mergeRecipientsWithUsersAndRemoveUnusedRecipients(JLjava/util/ArrayList;Ljava/util/ArrayList;)V
    .locals 24
    .param p1, "conversationRowId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRecipient;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 3597
    .local p3, "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    .local p4, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    new-instance v12, Ljava/util/HashSet;

    invoke-direct {v12}, Ljava/util/HashSet;-><init>()V

    .line 3598
    .local v12, "conversationRecipients":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/Long;>;"
    new-instance v23, Ljava/util/HashMap;

    invoke-direct/range {v23 .. v23}, Ljava/util/HashMap;-><init>()V

    .line 3599
    .local v23, "userMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Long;Lco/vine/android/api/VineUser;>;"
    invoke-virtual/range {p4 .. p4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v16

    .local v16, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v22

    check-cast v22, Lco/vine/android/api/VineUser;

    .line 3600
    .local v22, "user":Lco/vine/android/api/VineUser;
    move-object/from16 v0, v22

    iget-wide v3, v0, Lco/vine/android/api/VineUser;->userId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    move-object/from16 v0, v23

    move-object/from16 v1, v22

    invoke-virtual {v0, v3, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 3603
    .end local v22    # "user":Lco/vine/android/api/VineUser;
    :cond_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 3604
    .local v2, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v3, "conversation_recipients"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v6, "user_row_id"

    aput-object v6, v4, v5

    const-string v5, "conversation_row_id =? "

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-virtual/range {v2 .. v9}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 3609
    .local v11, "c":Landroid/database/Cursor;
    if-eqz v11, :cond_2

    .line 3611
    const/4 v3, -0x1

    :try_start_0
    invoke-interface {v11, v3}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 3612
    :goto_1
    invoke-interface {v11}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 3613
    const/4 v3, 0x0

    invoke-interface {v11, v3}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v12, v3}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 3616
    :catchall_0
    move-exception v3

    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    throw v3

    :cond_1
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 3623
    :cond_2
    :try_start_1
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 3624
    invoke-virtual/range {p3 .. p3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v16

    :cond_3
    :goto_2
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_4

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Lco/vine/android/api/VineRecipient;

    .line 3625
    .local v19, "recipient":Lco/vine/android/api/VineRecipient;
    if-eqz v19, :cond_3

    move-object/from16 v0, v19

    iget-wide v3, v0, Lco/vine/android/api/VineRecipient;->userId:J

    const-wide/16 v5, 0x0

    cmp-long v3, v3, v5

    if-lez v3, :cond_3

    move-object/from16 v0, v19

    iget-wide v3, v0, Lco/vine/android/api/VineRecipient;->recipientId:J

    const-wide/16 v5, 0x0

    cmp-long v3, v3, v5

    if-lez v3, :cond_3

    .line 3626
    new-instance v13, Landroid/content/ContentValues;

    invoke-direct {v13}, Landroid/content/ContentValues;-><init>()V

    .line 3627
    .local v13, "cv":Landroid/content/ContentValues;
    move-object/from16 v0, v19

    iget-wide v3, v0, Lco/vine/android/api/VineRecipient;->userId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    move-object/from16 v0, v23

    invoke-virtual {v0, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v22

    check-cast v22, Lco/vine/android/api/VineUser;

    .line 3628
    .restart local v22    # "user":Lco/vine/android/api/VineUser;
    if-eqz v22, :cond_3

    .line 3629
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-direct {v0, v13, v1, v3, v4}, Lco/vine/android/provider/VineDatabaseHelper;->fillUserContentValues(Landroid/content/ContentValues;Lco/vine/android/api/VineUser;J)V

    .line 3630
    const-string v3, "users"

    const-string v4, "_id=? "

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    move-object/from16 v0, v19

    iget-wide v7, v0, Lco/vine/android/api/VineRecipient;->recipientId:J

    invoke-static {v7, v8}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v2, v3, v13, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 3631
    move-object/from16 v0, v19

    iget-wide v3, v0, Lco/vine/android/api/VineRecipient;->recipientId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v12, v3}, Ljava/util/HashSet;->remove(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_2

    .line 3637
    .end local v13    # "cv":Landroid/content/ContentValues;
    .end local v19    # "recipient":Lco/vine/android/api/VineRecipient;
    .end local v22    # "user":Lco/vine/android/api/VineUser;
    :catchall_1
    move-exception v3

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v3

    .line 3635
    :cond_4
    :try_start_2
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 3637
    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 3640
    invoke-virtual {v12}, Ljava/util/HashSet;->size()I

    move-result v3

    if-lez v3, :cond_7

    .line 3644
    :try_start_3
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 3646
    const/4 v15, 0x0

    .line 3647
    .local v15, "i":I
    invoke-virtual {v12}, Ljava/util/HashSet;->size()I

    move-result v21

    .line 3648
    .local v21, "size":I
    move/from16 v0, v21

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 v20, v0

    .line 3651
    .local v20, "recipientsStringArray":[Ljava/lang/String;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    .line 3652
    .local v10, "builder":Ljava/lang/StringBuilder;
    const-string v3, " IN ("

    invoke-virtual {v10, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3654
    invoke-virtual {v12}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v16

    :goto_3
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_6

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Ljava/lang/Long;

    .line 3655
    .local v18, "l":Ljava/lang/Long;
    const-string v3, "?"

    invoke-virtual {v10, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3656
    invoke-virtual/range {v18 .. v18}, Ljava/lang/Long;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v20, v15

    .line 3657
    add-int/lit8 v3, v21, -0x1

    if-eq v15, v3, :cond_5

    .line 3658
    const-string v3, ", "

    invoke-virtual {v10, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3660
    :cond_5
    add-int/lit8 v15, v15, 0x1

    .line 3661
    goto :goto_3

    .line 3662
    .end local v18    # "l":Ljava/lang/Long;
    :cond_6
    const-string v3, ")"

    invoke-virtual {v10, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3664
    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    .line 3665
    .local v17, "inClause":Ljava/lang/String;
    const-string v3, "users"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "_id"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v20

    invoke-virtual {v2, v3, v4, v0}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v14

    .line 3666
    .local v14, "deleted":I
    const-string v3, "conversation_recipients"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "user_row_id"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v20

    invoke-virtual {v2, v3, v4, v0}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v3

    add-int/2addr v14, v3

    .line 3668
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 3670
    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 3673
    .end local v10    # "builder":Ljava/lang/StringBuilder;
    .end local v14    # "deleted":I
    .end local v15    # "i":I
    .end local v17    # "inClause":Ljava/lang/String;
    .end local v20    # "recipientsStringArray":[Ljava/lang/String;
    .end local v21    # "size":I
    :cond_7
    return-void

    .line 3670
    :catchall_2
    move-exception v3

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v3
.end method

.method public declared-synchronized mergeSearchedTags(Ljava/util/Collection;II)I
    .locals 23
    .param p2, "next"    # I
    .param p3, "previous"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lco/vine/android/api/VineTag;",
            ">;II)I"
        }
    .end annotation

    .prologue
    .line 1631
    .local p1, "tags":Ljava/util/Collection;, "Ljava/util/Collection<Lco/vine/android/api/VineTag;>;"
    monitor-enter p0

    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v3

    .line 1634
    .local v3, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v15, Ljava/util/HashMap;

    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->size()I

    move-result v4

    invoke-direct {v15, v4}, Ljava/util/HashMap;-><init>(I)V

    .line 1635
    .local v15, "newTags":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Long;Lco/vine/android/api/VineTag;>;"
    new-instance v21, Ljava/util/HashMap;

    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->size()I

    move-result v4

    move-object/from16 v0, v21

    invoke-direct {v0, v4}, Ljava/util/HashMap;-><init>(I)V

    .line 1636
    .local v21, "updatedTags":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Long;Lco/vine/android/api/VineTag;>;"
    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v14

    .local v14, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v14}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v14}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Lco/vine/android/api/VineTag;

    .line 1637
    .local v18, "tag":Lco/vine/android/api/VineTag;
    move-object/from16 v0, v18

    iget-wide v4, v0, Lco/vine/android/api/VineTag;->tagId:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    move-object/from16 v0, v18

    invoke-virtual {v15, v4, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 1631
    .end local v3    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v14    # "i$":Ljava/util/Iterator;
    .end local v15    # "newTags":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Long;Lco/vine/android/api/VineTag;>;"
    .end local v18    # "tag":Lco/vine/android/api/VineTag;
    .end local v21    # "updatedTags":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Long;Lco/vine/android/api/VineTag;>;"
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 1641
    .restart local v3    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v14    # "i$":Ljava/util/Iterator;
    .restart local v15    # "newTags":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Long;Lco/vine/android/api/VineTag;>;"
    .restart local v21    # "updatedTags":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Long;Lco/vine/android/api/VineTag;>;"
    :cond_0
    :try_start_1
    const-string v4, "tag_search_results"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    const-string v7, "tag_id"

    aput-object v7, v5, v6

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-virtual/range {v3 .. v10}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v13

    .line 1644
    .local v13, "c":Landroid/database/Cursor;
    if-eqz v13, :cond_3

    .line 1648
    :cond_1
    :goto_1
    :try_start_2
    invoke-interface {v13}, Landroid/database/Cursor;->moveToNext()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 1649
    const-string v4, "tag_id"

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v13, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v19

    .line 1650
    .local v19, "tagId":J
    invoke-static/range {v19 .. v20}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v15, v4}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Lco/vine/android/api/VineTag;

    .line 1651
    .restart local v18    # "tag":Lco/vine/android/api/VineTag;
    if-eqz v18, :cond_1

    .line 1652
    invoke-static/range {v19 .. v20}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    move-object/from16 v0, v21

    move-object/from16 v1, v18

    invoke-virtual {v0, v4, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_1

    .line 1656
    .end local v18    # "tag":Lco/vine/android/api/VineTag;
    .end local v19    # "tagId":J
    :catchall_1
    move-exception v4

    :try_start_3
    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    throw v4

    :cond_2
    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    .line 1660
    :cond_3
    const/16 v16, 0x0

    .line 1661
    .local v16, "numInserted":I
    const/16 v17, 0x0

    .line 1663
    .local v17, "numUpdated":I
    invoke-virtual {v15}, Ljava/util/HashMap;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_6

    .line 1664
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1666
    :try_start_4
    new-instance v22, Landroid/content/ContentValues;

    invoke-direct/range {v22 .. v22}, Landroid/content/ContentValues;-><init>()V

    .line 1667
    .local v22, "values":Landroid/content/ContentValues;
    invoke-virtual {v15}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v14

    :goto_2
    invoke-interface {v14}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_5

    invoke-interface {v14}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Lco/vine/android/api/VineTag;

    .line 1668
    .restart local v18    # "tag":Lco/vine/android/api/VineTag;
    invoke-virtual/range {v22 .. v22}, Landroid/content/ContentValues;->clear()V

    .line 1669
    move-object/from16 v0, p0

    move-object/from16 v1, v22

    move-object/from16 v2, v18

    invoke-direct {v0, v1, v2}, Lco/vine/android/provider/VineDatabaseHelper;->fillTagValues(Landroid/content/ContentValues;Lco/vine/android/api/VineTag;)V

    .line 1670
    const-string v4, "tag_search_results"

    const-string v5, "tag_id"

    move-object/from16 v0, v22

    invoke-virtual {v3, v4, v5, v0}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmp-long v4, v4, v6

    if-lez v4, :cond_4

    const/4 v4, 0x1

    :goto_3
    add-int v16, v16, v4

    .line 1672
    goto :goto_2

    .line 1670
    :cond_4
    const/4 v4, 0x0

    goto :goto_3

    .line 1673
    .end local v18    # "tag":Lco/vine/android/api/VineTag;
    :cond_5
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 1675
    :try_start_5
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 1679
    .end local v22    # "values":Landroid/content/ContentValues;
    :cond_6
    invoke-virtual/range {v21 .. v21}, Ljava/util/HashMap;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_9

    .line 1680
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 1682
    :try_start_6
    new-instance v22, Landroid/content/ContentValues;

    invoke-direct/range {v22 .. v22}, Landroid/content/ContentValues;-><init>()V

    .line 1683
    .restart local v22    # "values":Landroid/content/ContentValues;
    invoke-virtual/range {v21 .. v21}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v14

    :goto_4
    invoke-interface {v14}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_8

    invoke-interface {v14}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Lco/vine/android/api/VineTag;

    .line 1684
    .restart local v18    # "tag":Lco/vine/android/api/VineTag;
    invoke-virtual/range {v22 .. v22}, Landroid/content/ContentValues;->clear()V

    .line 1685
    move-object/from16 v0, p0

    move-object/from16 v1, v22

    move-object/from16 v2, v18

    invoke-direct {v0, v1, v2}, Lco/vine/android/provider/VineDatabaseHelper;->fillTagValues(Landroid/content/ContentValues;Lco/vine/android/api/VineTag;)V

    .line 1686
    const-string v4, "tag_search_results"

    const-string v5, "tag_id=?"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    move-object/from16 v0, v18

    iget-wide v8, v0, Lco/vine/android/api/VineTag;->tagId:J

    invoke-static {v8, v9}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    move-object/from16 v0, v22

    invoke-virtual {v3, v4, v0, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_3

    move-result v4

    if-lez v4, :cond_7

    const/4 v4, 0x1

    :goto_5
    add-int v17, v17, v4

    .line 1689
    goto :goto_4

    .line 1675
    .end local v18    # "tag":Lco/vine/android/api/VineTag;
    .end local v22    # "values":Landroid/content/ContentValues;
    :catchall_2
    move-exception v4

    :try_start_7
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v4
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 1686
    .restart local v18    # "tag":Lco/vine/android/api/VineTag;
    .restart local v22    # "values":Landroid/content/ContentValues;
    :cond_7
    const/4 v4, 0x0

    goto :goto_5

    .line 1690
    .end local v18    # "tag":Lco/vine/android/api/VineTag;
    :cond_8
    :try_start_8
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_3

    .line 1692
    :try_start_9
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 1696
    .end local v22    # "values":Landroid/content/ContentValues;
    :cond_9
    if-gtz v16, :cond_a

    if-lez v17, :cond_d

    .line 1697
    :cond_a
    if-gtz p2, :cond_b

    if-lez p3, :cond_c

    .line 1698
    :cond_b
    const/4 v5, 0x4

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-wide/16 v10, 0x0

    const/4 v12, 0x1

    move-object/from16 v4, p0

    move/from16 v8, p2

    move/from16 v9, p3

    invoke-virtual/range {v4 .. v12}, Lco/vine/android/provider/VineDatabaseHelper;->savePageCursor(IILjava/lang/String;IIJZ)I

    .line 1700
    :cond_c
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v5, Lco/vine/android/provider/Vine$TagSearchResults;->CONTENT_URI:Landroid/net/Uri;

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 1703
    :cond_d
    sget-boolean v4, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v4, :cond_e

    .line 1704
    const-string v4, "VineDH"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Inserted "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move/from16 v0, v16

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " and updated "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move/from16 v0, v17

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " tags."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 1707
    :cond_e
    monitor-exit p0

    return v16

    .line 1692
    :catchall_3
    move-exception v4

    :try_start_a
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v4
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_0
.end method

.method public declared-synchronized mergeSuggestedTag(Lco/vine/android/api/VineTag;)Landroid/net/Uri;
    .locals 10
    .param p1, "tag"    # Lco/vine/android/api/VineTag;

    .prologue
    const/4 v9, 0x1

    .line 1174
    monitor-enter p0

    const/4 v7, 0x0

    .line 1177
    .local v7, "result":Landroid/net/Uri;
    :try_start_0
    const-string v3, "tag_id=?"

    .line 1178
    .local v3, "selection":Ljava/lang/String;
    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    iget-wide v1, p1, Lco/vine/android/api/VineTag;->tagId:J

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v0

    .line 1179
    .local v4, "selectionArgs":[Ljava/lang/String;
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v1, Lco/vine/android/provider/Vine$TagsRecentlyUsed;->CONTENT_URI:Landroid/net/Uri;

    sget-object v2, Lco/vine/android/provider/VineDatabaseSQL$TagsRecentlyUsedQuery;->PROJECTION:[Ljava/lang/String;

    const-string v5, "_id DESC"

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 1183
    .local v6, "c":Landroid/database/Cursor;
    if-eqz v6, :cond_1

    .line 1184
    new-instance v8, Landroid/content/ContentValues;

    invoke-direct {v8}, Landroid/content/ContentValues;-><init>()V

    .line 1185
    .local v8, "values":Landroid/content/ContentValues;
    invoke-interface {v6}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-ge v0, v9, :cond_2

    .line 1186
    invoke-direct {p0, v8, p1}, Lco/vine/android/provider/VineDatabaseHelper;->fillTagValues(Landroid/content/ContentValues;Lco/vine/android/api/VineTag;)V

    .line 1187
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v1, Lco/vine/android/provider/Vine$TagsRecentlyUsed;->CONTENT_URI_PUT_TAG:Landroid/net/Uri;

    invoke-virtual {v0, v1, v8}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v7

    .line 1195
    :cond_0
    :goto_0
    invoke-interface {v6}, Landroid/database/Cursor;->close()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1197
    .end local v8    # "values":Landroid/content/ContentValues;
    :cond_1
    monitor-exit p0

    return-object v7

    .line 1188
    .restart local v8    # "values":Landroid/content/ContentValues;
    :cond_2
    :try_start_1
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1189
    const-string v3, "tag_id=?"

    .line 1190
    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    .end local v4    # "selectionArgs":[Ljava/lang/String;
    const/4 v0, 0x0

    iget-wide v1, p1, Lco/vine/android/api/VineTag;->tagId:J

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v0

    .line 1191
    .restart local v4    # "selectionArgs":[Ljava/lang/String;
    const-string v0, "last_used_timestamp"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v8, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1192
    iget-object v0, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v1, Lco/vine/android/provider/Vine$TagsRecentlyUsed;->CONTENT_URI_UPDATE_RECENT_TAG:Landroid/net/Uri;

    invoke-virtual {v0, v1, v8, v3, v4}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 1174
    .end local v3    # "selection":Ljava/lang/String;
    .end local v4    # "selectionArgs":[Ljava/lang/String;
    .end local v6    # "c":Landroid/database/Cursor;
    .end local v8    # "values":Landroid/content/ContentValues;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public mergeUserAndGetResultingRowId(Lco/vine/android/api/VineUser;)J
    .locals 13
    .param p1, "user"    # Lco/vine/android/api/VineUser;

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    const/4 v12, 0x0

    .line 3515
    new-instance v11, Landroid/content/ContentValues;

    invoke-direct {v11}, Landroid/content/ContentValues;-><init>()V

    .line 3516
    .local v11, "values":Landroid/content/ContentValues;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    invoke-direct {p0, v11, p1, v1, v2}, Lco/vine/android/provider/VineDatabaseHelper;->fillUserContentValues(Landroid/content/ContentValues;Lco/vine/android/api/VineUser;J)V

    .line 3517
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3518
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "users"

    new-array v2, v4, [Ljava/lang/String;

    const-string v3, "_id"

    aput-object v3, v2, v12

    const-string v3, "user_id=?"

    new-array v4, v4, [Ljava/lang/String;

    iget-wide v6, p1, Lco/vine/android/api/VineUser;->userId:J

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v12

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 3520
    .local v8, "c":Landroid/database/Cursor;
    if-eqz v8, :cond_1

    .line 3522
    :try_start_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 3523
    const/4 v1, 0x0

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v9

    .line 3524
    .local v9, "updateId":J
    const-string v1, "users"

    const-string v2, "_id=?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {v9, v10}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v11, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 3528
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 3531
    .end local v9    # "updateId":J
    :goto_0
    return-wide v9

    .line 3528
    :cond_0
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 3531
    :cond_1
    const-string v1, "users"

    invoke-virtual {v0, v1, v5, v11}, Landroid/database/sqlite/SQLiteDatabase;->insertOrThrow(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v9

    goto :goto_0

    .line 3528
    :catchall_0
    move-exception v1

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method public declared-synchronized mergeUsers(Ljava/util/Collection;ILjava/lang/String;IILco/vine/android/util/LongSparseArray;)I
    .locals 8
    .param p2, "type"    # I
    .param p3, "groupTag"    # Ljava/lang/String;
    .param p4, "next"    # I
    .param p5, "previous"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;I",
            "Ljava/lang/String;",
            "II",
            "Lco/vine/android/util/LongSparseArray",
            "<",
            "Ljava/lang/Long;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 1419
    .local p1, "users":Ljava/util/Collection;, "Ljava/util/Collection<Lco/vine/android/api/VineUser;>;"
    .local p6, "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    monitor-enter p0

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move v4, p4

    move v5, p5

    move-object v7, p6

    :try_start_0
    invoke-virtual/range {v0 .. v7}, Lco/vine/android/provider/VineDatabaseHelper;->mergeUsers(Ljava/util/Collection;ILjava/lang/String;IILco/vine/android/util/LongSparseArray;Lco/vine/android/util/LongSparseArray;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized mergeUsers(Ljava/util/Collection;ILjava/lang/String;IILco/vine/android/util/LongSparseArray;JI)I
    .locals 11
    .param p2, "type"    # I
    .param p3, "groupTag"    # Ljava/lang/String;
    .param p4, "next"    # I
    .param p5, "previous"    # I
    .param p7, "sectionRefreshTime"    # J
    .param p9, "sectionType"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;I",
            "Ljava/lang/String;",
            "II",
            "Lco/vine/android/util/LongSparseArray",
            "<",
            "Ljava/lang/Long;",
            ">;JI)I"
        }
    .end annotation

    .prologue
    .line 1414
    .local p1, "users":Ljava/util/Collection;, "Ljava/util/Collection<Lco/vine/android/api/VineUser;>;"
    .local p6, "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    monitor-enter p0

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move v4, p4

    move/from16 v5, p5

    move-object/from16 v7, p6

    move-wide/from16 v8, p7

    move/from16 v10, p9

    :try_start_0
    invoke-virtual/range {v0 .. v10}, Lco/vine/android/provider/VineDatabaseHelper;->mergeUsers(Ljava/util/Collection;ILjava/lang/String;IILco/vine/android/util/LongSparseArray;Lco/vine/android/util/LongSparseArray;JI)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized mergeUsers(Ljava/util/Collection;ILjava/lang/String;IILco/vine/android/util/LongSparseArray;Lco/vine/android/util/LongSparseArray;)I
    .locals 11
    .param p2, "type"    # I
    .param p3, "groupTag"    # Ljava/lang/String;
    .param p4, "next"    # I
    .param p5, "previous"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;I",
            "Ljava/lang/String;",
            "II",
            "Lco/vine/android/util/LongSparseArray",
            "<",
            "Ljava/lang/Long;",
            ">;",
            "Lco/vine/android/util/LongSparseArray",
            "<",
            "Ljava/lang/Long;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 1425
    .local p1, "users":Ljava/util/Collection;, "Ljava/util/Collection<Lco/vine/android/api/VineUser;>;"
    .local p6, "tagMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    .local p7, "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    monitor-enter p0

    const-wide/16 v8, -0x1

    const/4 v10, -0x1

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move v4, p4

    move/from16 v5, p5

    move-object/from16 v6, p6

    move-object/from16 v7, p7

    :try_start_0
    invoke-virtual/range {v0 .. v10}, Lco/vine/android/provider/VineDatabaseHelper;->mergeUsers(Ljava/util/Collection;ILjava/lang/String;IILco/vine/android/util/LongSparseArray;Lco/vine/android/util/LongSparseArray;JI)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized mergeUsers(Ljava/util/Collection;ILjava/lang/String;IILco/vine/android/util/LongSparseArray;Lco/vine/android/util/LongSparseArray;JI)I
    .locals 34
    .param p2, "type"    # I
    .param p3, "groupTag"    # Ljava/lang/String;
    .param p4, "next"    # I
    .param p5, "previous"    # I
    .param p8, "sectionRefreshTime"    # J
    .param p10, "sectionType"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;I",
            "Ljava/lang/String;",
            "II",
            "Lco/vine/android/util/LongSparseArray",
            "<",
            "Ljava/lang/Long;",
            ">;",
            "Lco/vine/android/util/LongSparseArray",
            "<",
            "Ljava/lang/Long;",
            ">;JI)I"
        }
    .end annotation

    .prologue
    .line 1477
    .local p1, "users":Ljava/util/Collection;, "Ljava/util/Collection<Lco/vine/android/api/VineUser;>;"
    .local p6, "tagMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    .local p7, "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    monitor-enter p0

    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v3

    .line 1480
    .local v3, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v23, Lco/vine/android/util/LongSparseArray;

    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->size()I

    move-result v4

    move-object/from16 v0, v23

    invoke-direct {v0, v4}, Lco/vine/android/util/LongSparseArray;-><init>(I)V

    .line 1481
    .local v23, "newUsers":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VineUser;>;"
    new-instance v31, Lco/vine/android/util/LongSparseArray;

    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->size()I

    move-result v4

    move-object/from16 v0, v31

    invoke-direct {v0, v4}, Lco/vine/android/util/LongSparseArray;-><init>(I)V

    .line 1482
    .local v31, "updatedUsers":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VineUser;>;"
    invoke-interface/range {p1 .. p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v20

    .local v20, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface/range {v20 .. v20}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface/range {v20 .. v20}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lco/vine/android/api/VineUser;

    .line 1483
    .local v7, "user":Lco/vine/android/api/VineUser;
    iget-wide v4, v7, Lco/vine/android/api/VineUser;->userId:J

    move-object/from16 v0, v23

    invoke-virtual {v0, v4, v5, v7}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 1477
    .end local v3    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v7    # "user":Lco/vine/android/api/VineUser;
    .end local v20    # "i$":Ljava/util/Iterator;
    .end local v23    # "newUsers":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VineUser;>;"
    .end local v31    # "updatedUsers":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VineUser;>;"
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 1487
    .restart local v3    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v20    # "i$":Ljava/util/Iterator;
    .restart local v23    # "newUsers":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VineUser;>;"
    .restart local v31    # "updatedUsers":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VineUser;>;"
    :cond_0
    :try_start_1
    const-string v4, "users"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v8, 0x0

    const-string v9, "user_id"

    aput-object v9, v5, v8

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-virtual/range {v3 .. v10}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v17

    .line 1489
    .local v17, "c":Landroid/database/Cursor;
    if-eqz v17, :cond_3

    .line 1493
    :cond_1
    :goto_1
    :try_start_2
    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->moveToNext()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 1494
    const/4 v4, 0x0

    move-object/from16 v0, v17

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v32

    .line 1495
    .local v32, "userId":J
    move-object/from16 v0, v23

    move-wide/from16 v1, v32

    invoke-virtual {v0, v1, v2}, Lco/vine/android/util/LongSparseArray;->removeKey(J)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lco/vine/android/api/VineUser;

    .line 1496
    .restart local v7    # "user":Lco/vine/android/api/VineUser;
    if-eqz v7, :cond_1

    .line 1497
    move-object/from16 v0, v31

    move-wide/from16 v1, v32

    invoke-virtual {v0, v1, v2, v7}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_1

    .line 1502
    .end local v7    # "user":Lco/vine/android/api/VineUser;
    .end local v32    # "userId":J
    :catchall_1
    move-exception v4

    :try_start_3
    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->close()V

    throw v4

    :cond_2
    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->close()V

    .line 1506
    :cond_3
    const/16 v24, 0x0

    .line 1507
    .local v24, "numInserted":I
    const/16 v25, 0x0

    .line 1509
    .local v25, "numUpdated":I
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v21

    .line 1511
    .local v21, "lastRefreshTime":J
    invoke-virtual/range {v23 .. v23}, Lco/vine/android/util/LongSparseArray;->size()I

    move-result v29

    .line 1512
    .local v29, "size":I
    if-lez v29, :cond_6

    .line 1513
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1515
    :try_start_4
    new-instance v6, Landroid/content/ContentValues;

    invoke-direct {v6}, Landroid/content/ContentValues;-><init>()V

    .line 1516
    .local v6, "values":Landroid/content/ContentValues;
    const/16 v19, 0x0

    .local v19, "i":I
    :goto_2
    move/from16 v0, v19

    move/from16 v1, v29

    if-ge v0, v1, :cond_5

    .line 1517
    move-object/from16 v0, v23

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lco/vine/android/api/VineUser;

    .line 1518
    .restart local v7    # "user":Lco/vine/android/api/VineUser;
    invoke-virtual {v6}, Landroid/content/ContentValues;->clear()V

    .line 1519
    move-object/from16 v0, p0

    move-wide/from16 v1, v21

    invoke-direct {v0, v6, v7, v1, v2}, Lco/vine/android/provider/VineDatabaseHelper;->fillUserContentValues(Landroid/content/ContentValues;Lco/vine/android/api/VineUser;J)V

    .line 1520
    const-string v4, "users"

    const-string v5, "user_id"

    invoke-virtual {v3, v4, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v4

    const-wide/16 v8, 0x0

    cmp-long v4, v4, v8

    if-lez v4, :cond_4

    const/4 v4, 0x1

    :goto_3
    add-int v24, v24, v4

    move-object/from16 v4, p0

    move-object v5, v3

    move-wide/from16 v8, p8

    move/from16 v10, p10

    .line 1521
    invoke-direct/range {v4 .. v10}, Lco/vine/android/provider/VineDatabaseHelper;->mergetUserSection(Landroid/database/sqlite/SQLiteDatabase;Landroid/content/ContentValues;Lco/vine/android/api/VineUser;JI)V

    .line 1516
    add-int/lit8 v19, v19, 0x1

    goto :goto_2

    .line 1520
    :cond_4
    const/4 v4, 0x0

    goto :goto_3

    .line 1523
    .end local v7    # "user":Lco/vine/android/api/VineUser;
    :cond_5
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 1525
    :try_start_5
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 1529
    .end local v6    # "values":Landroid/content/ContentValues;
    .end local v19    # "i":I
    :cond_6
    invoke-virtual/range {v31 .. v31}, Lco/vine/android/util/LongSparseArray;->size()I

    move-result v29

    .line 1530
    if-lez v29, :cond_9

    .line 1531
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 1533
    :try_start_6
    new-instance v6, Landroid/content/ContentValues;

    invoke-direct {v6}, Landroid/content/ContentValues;-><init>()V

    .line 1534
    .restart local v6    # "values":Landroid/content/ContentValues;
    const/16 v19, 0x0

    .restart local v19    # "i":I
    :goto_4
    move/from16 v0, v19

    move/from16 v1, v29

    if-ge v0, v1, :cond_8

    .line 1535
    move-object/from16 v0, v31

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lco/vine/android/api/VineUser;

    .line 1536
    .restart local v7    # "user":Lco/vine/android/api/VineUser;
    invoke-virtual {v6}, Landroid/content/ContentValues;->clear()V

    .line 1537
    move-object/from16 v0, p0

    move-wide/from16 v1, v21

    invoke-direct {v0, v6, v7, v1, v2}, Lco/vine/android/provider/VineDatabaseHelper;->fillUserContentValues(Landroid/content/ContentValues;Lco/vine/android/api/VineUser;J)V

    .line 1538
    const-string v4, "users"

    const-string v5, "user_id=?"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    iget-wide v10, v7, Lco/vine/android/api/VineUser;->userId:J

    invoke-static {v10, v11}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-virtual {v3, v4, v6, v5, v8}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v4

    if-lez v4, :cond_7

    const/4 v4, 0x1

    :goto_5
    add-int v25, v25, v4

    move-object/from16 v4, p0

    move-object v5, v3

    move-wide/from16 v8, p8

    move/from16 v10, p10

    .line 1540
    invoke-direct/range {v4 .. v10}, Lco/vine/android/provider/VineDatabaseHelper;->mergetUserSection(Landroid/database/sqlite/SQLiteDatabase;Landroid/content/ContentValues;Lco/vine/android/api/VineUser;JI)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_3

    .line 1534
    add-int/lit8 v19, v19, 0x1

    goto :goto_4

    .line 1525
    .end local v6    # "values":Landroid/content/ContentValues;
    .end local v7    # "user":Lco/vine/android/api/VineUser;
    .end local v19    # "i":I
    :catchall_2
    move-exception v4

    :try_start_7
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v4
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 1538
    .restart local v6    # "values":Landroid/content/ContentValues;
    .restart local v7    # "user":Lco/vine/android/api/VineUser;
    .restart local v19    # "i":I
    :cond_7
    const/4 v4, 0x0

    goto :goto_5

    .line 1542
    .end local v7    # "user":Lco/vine/android/api/VineUser;
    :cond_8
    :try_start_8
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_3

    .line 1544
    :try_start_9
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 1550
    .end local v6    # "values":Landroid/content/ContentValues;
    .end local v19    # "i":I
    :cond_9
    const/16 v18, 0x0

    .line 1551
    .local v18, "deleted":I
    if-lez v24, :cond_d

    .line 1552
    const-string v9, "users"

    sget-object v10, Lco/vine/android/provider/VineDatabaseSQL$TableQuery;->PROJECTION:[Ljava/lang/String;

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    move-object v8, v3

    invoke-virtual/range {v8 .. v15}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    move-result-object v30

    .line 1555
    .local v30, "tableCursor":Landroid/database/Cursor;
    if-eqz v30, :cond_d

    .line 1557
    :try_start_a
    invoke-interface/range {v30 .. v30}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v4

    if-eqz v4, :cond_c

    .line 1558
    invoke-interface/range {v30 .. v30}, Landroid/database/Cursor;->getCount()I
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_6

    move-result v29

    .line 1559
    const/16 v4, 0x2710

    move/from16 v0, v29

    if-le v0, v4, :cond_c

    .line 1561
    :try_start_b
    const-string v4, "SELECT last_refresh FROM users ORDER BY last_refresh DESC LIMIT 1 OFFSET 5000"

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v28

    .line 1567
    .local v28, "oldestRefreshId":Landroid/database/Cursor;
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_5

    .line 1568
    if-eqz v28, :cond_b

    .line 1570
    :try_start_c
    invoke-interface/range {v28 .. v28}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v4

    if-eqz v4, :cond_a

    .line 1571
    const/4 v4, 0x0

    move-object/from16 v0, v28

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v26

    .line 1573
    .local v26, "oldestNthId":J
    const-string v4, "DELETE FROM user_groups WHERE user_id IN (SELECT user_id FROM users WHERE last_refresh < ?);"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v8, 0x0

    invoke-static/range {v26 .. v27}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v5, v8

    invoke-virtual {v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1579
    const-string v4, "users"

    const-string v5, "last_refresh<?"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    invoke-static/range {v26 .. v27}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-virtual {v3, v4, v5, v8}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v18

    .line 1581
    sget-boolean v4, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v4, :cond_a

    .line 1582
    const-string v4, "s"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Due to reaching maximum table size ("

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move/from16 v0, v29

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v8, " with a max of "

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const/16 v8, 0x2710

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v8, "), deleted "

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move/from16 v0, v18

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v8, " users, all less than last refresh of "

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-wide/from16 v0, v26

    invoke-virtual {v5, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_4

    .line 1589
    .end local v26    # "oldestNthId":J
    :cond_a
    :try_start_d
    invoke-interface/range {v28 .. v28}, Landroid/database/Cursor;->close()V

    .line 1592
    :cond_b
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_5

    .line 1594
    :try_start_e
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_6

    .line 1599
    .end local v28    # "oldestRefreshId":Landroid/database/Cursor;
    :cond_c
    :try_start_f
    invoke-interface/range {v30 .. v30}, Landroid/database/Cursor;->close()V

    .line 1604
    .end local v30    # "tableCursor":Landroid/database/Cursor;
    :cond_d
    if-gtz v24, :cond_e

    if-gtz v25, :cond_e

    if-lez v18, :cond_11

    .line 1605
    :cond_e
    const/4 v4, -0x1

    move/from16 v0, p2

    if-eq v0, v4, :cond_10

    move-object/from16 v8, p0

    move-object/from16 v9, p1

    move/from16 v10, p2

    move-object/from16 v11, p3

    move-object/from16 v12, p6

    move-object/from16 v13, p7

    .line 1606
    invoke-direct/range {v8 .. v13}, Lco/vine/android/provider/VineDatabaseHelper;->mergeUserGroups(Ljava/util/Collection;ILjava/lang/String;Lco/vine/android/util/LongSparseArray;Lco/vine/android/util/LongSparseArray;)V

    .line 1607
    if-gtz p4, :cond_f

    if-lez p5, :cond_10

    .line 1608
    :cond_f
    const/4 v9, 0x1

    const-wide/16 v14, 0x0

    const/16 v16, 0x1

    move-object/from16 v8, p0

    move/from16 v10, p2

    move-object/from16 v11, p3

    move/from16 v12, p4

    move/from16 v13, p5

    invoke-virtual/range {v8 .. v16}, Lco/vine/android/provider/VineDatabaseHelper;->savePageCursor(IILjava/lang/String;IIJZ)I

    .line 1612
    :cond_10
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v5, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI:Landroid/net/Uri;

    const/4 v8, 0x0

    invoke-virtual {v4, v5, v8}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 1613
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v5, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FIND_FRIENDS_TWITTER:Landroid/net/Uri;

    const/4 v8, 0x0

    invoke-virtual {v4, v5, v8}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 1614
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v5, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FIND_FRIENDS_ADDRESS:Landroid/net/Uri;

    const/4 v8, 0x0

    invoke-virtual {v4, v5, v8}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 1615
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v5, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_LIKERS:Landroid/net/Uri;

    const/4 v8, 0x0

    invoke-virtual {v4, v5, v8}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 1616
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v5, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FOLLOWERS:Landroid/net/Uri;

    const/4 v8, 0x0

    invoke-virtual {v4, v5, v8}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 1617
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v5, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FOLLOWING:Landroid/net/Uri;

    const/4 v8, 0x0

    invoke-virtual {v4, v5, v8}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 1618
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v5, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FRIENDS:Landroid/net/Uri;

    const/4 v8, 0x0

    invoke-virtual {v4, v5, v8}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 1619
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v5, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_USER_SEARCH_RESULTS:Landroid/net/Uri;

    const/4 v8, 0x0

    invoke-virtual {v4, v5, v8}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 1622
    :cond_11
    sget-boolean v4, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v4, :cond_12

    .line 1623
    const-string v4, "VineDH"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Inserted "

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move/from16 v0, v24

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v8, " new users and updating "

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move/from16 v0, v25

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v8, " of type "

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move/from16 v0, p2

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v8, "."

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_f
    .catchall {:try_start_f .. :try_end_f} :catchall_0

    .line 1627
    :cond_12
    monitor-exit p0

    return v24

    .line 1544
    .end local v18    # "deleted":I
    :catchall_3
    move-exception v4

    :try_start_10
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v4
    :try_end_10
    .catchall {:try_start_10 .. :try_end_10} :catchall_0

    .line 1589
    .restart local v18    # "deleted":I
    .restart local v28    # "oldestRefreshId":Landroid/database/Cursor;
    .restart local v30    # "tableCursor":Landroid/database/Cursor;
    :catchall_4
    move-exception v4

    :try_start_11
    invoke-interface/range {v28 .. v28}, Landroid/database/Cursor;->close()V

    throw v4
    :try_end_11
    .catchall {:try_start_11 .. :try_end_11} :catchall_5

    .line 1594
    .end local v28    # "oldestRefreshId":Landroid/database/Cursor;
    :catchall_5
    move-exception v4

    :try_start_12
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v4
    :try_end_12
    .catchall {:try_start_12 .. :try_end_12} :catchall_6

    .line 1599
    :catchall_6
    move-exception v4

    :try_start_13
    invoke-interface/range {v30 .. v30}, Landroid/database/Cursor;->close()V

    throw v4
    :try_end_13
    .catchall {:try_start_13 .. :try_end_13} :catchall_0
.end method

.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 0
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 133
    invoke-virtual {p0, p1}, Lco/vine/android/provider/VineDatabaseHelper;->createTables(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 134
    return-void
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 3
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 138
    sget-boolean v0, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v0, :cond_0

    .line 139
    const-string v0, "VineDH"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Upgrading from "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " to "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 141
    :cond_0
    invoke-direct {p0, p1}, Lco/vine/android/provider/VineDatabaseHelper;->dropTables(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 142
    invoke-virtual {p0, p1}, Lco/vine/android/provider/VineDatabaseHelper;->createTables(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 143
    return-void
.end method

.method public permaDeleteMessageFromRowId(J)V
    .locals 8
    .param p1, "messageRowId"    # J

    .prologue
    const/4 v6, 0x1

    .line 3437
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3439
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 3440
    .local v3, "values":Landroid/content/ContentValues;
    const-string v4, "deleted"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3442
    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    .line 3443
    .local v2, "messageIdString":Ljava/lang/String;
    const-string v4, "messages"

    const-string v5, "_id=?"

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object v2, v6, v7

    invoke-virtual {v0, v4, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 3445
    .local v1, "deleted":I
    if-lez v1, :cond_0

    .line 3446
    invoke-direct {p0}, Lco/vine/android/provider/VineDatabaseHelper;->notifyVMUris()V

    .line 3448
    :cond_0
    return-void
.end method

.method public removeAccount()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 3967
    const-string v0, "current_account"

    invoke-direct {p0, v0, v3}, Lco/vine/android/provider/VineDatabaseHelper;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 3968
    const-string v0, "current_user_id"

    const-wide/16 v1, 0x0

    invoke-direct {p0, v0, v1, v2}, Lco/vine/android/provider/VineDatabaseHelper;->setValue(Ljava/lang/String;J)V

    .line 3969
    const-string v0, "current_name"

    invoke-direct {p0, v0, v3}, Lco/vine/android/provider/VineDatabaseHelper;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 3970
    return-void
.end method

.method public declared-synchronized removeFollow(JZZ)I
    .locals 19
    .param p1, "userId"    # J
    .param p3, "deleteRow"    # Z
    .param p4, "notify"    # Z

    .prologue
    .line 816
    monitor-enter p0

    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 818
    .local v2, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v3, 0x1

    new-array v6, v3, [Ljava/lang/String;

    const/4 v3, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v6, v3

    .line 820
    .local v6, "whereArgs":[Ljava/lang/String;
    const-string v3, "users"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v7, "following_flag"

    aput-object v7, v4, v5

    const-string v5, "user_id=?"

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-virtual/range {v2 .. v9}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v13

    .line 823
    .local v13, "c":Landroid/database/Cursor;
    if-eqz v13, :cond_3

    .line 825
    :try_start_1
    invoke-interface {v13}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 826
    const/4 v3, 0x0

    invoke-interface {v13, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v14

    .line 827
    .local v14, "currentFriendship":I
    const/4 v3, 0x1

    invoke-static {v14, v3}, Lco/vine/android/Friendships;->unsetFriendship(II)I

    move-result v17

    .line 829
    .local v17, "newFriendship":I
    new-instance v15, Landroid/content/ContentValues;

    invoke-direct {v15}, Landroid/content/ContentValues;-><init>()V

    .line 830
    .local v15, "cv":Landroid/content/ContentValues;
    const-string v3, "following_flag"

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v15, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 832
    const-string v3, "users"

    const-string v4, "user_id=?"

    invoke-virtual {v2, v3, v15, v4, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v18

    .line 835
    .local v18, "result":I
    const/16 v16, 0x0

    .line 836
    .local v16, "deleted":I
    if-eqz p3, :cond_0

    .line 837
    const/4 v10, 0x1

    sget-object v12, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FOLLOWING:Landroid/net/Uri;

    move-object/from16 v7, p0

    move-wide/from16 v8, p1

    move/from16 v11, p4

    invoke-virtual/range {v7 .. v12}, Lco/vine/android/provider/VineDatabaseHelper;->removeUserWithType(JIZLandroid/net/Uri;)Z

    .line 841
    :cond_0
    sget-boolean v3, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v3, :cond_1

    .line 842
    const-string v3, "VineDH"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unfollowed user "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-wide/from16 v0, p1

    invoke-virtual {v4, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 847
    :cond_1
    :try_start_2
    invoke-interface {v13}, Landroid/database/Cursor;->close()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 850
    .end local v14    # "currentFriendship":I
    .end local v15    # "cv":Landroid/content/ContentValues;
    .end local v16    # "deleted":I
    .end local v17    # "newFriendship":I
    .end local v18    # "result":I
    :goto_0
    monitor-exit p0

    return v18

    .line 847
    :cond_2
    :try_start_3
    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    .line 850
    :cond_3
    const/16 v18, -0x1

    goto :goto_0

    .line 847
    :catchall_0
    move-exception v3

    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    throw v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 816
    .end local v2    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v6    # "whereArgs":[Ljava/lang/String;
    .end local v13    # "c":Landroid/database/Cursor;
    :catchall_1
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public declared-synchronized removeLike(JJZ)I
    .locals 13
    .param p1, "postId"    # J
    .param p3, "myUserId"    # J
    .param p5, "notify"    # Z

    .prologue
    .line 925
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    move-result-object v0

    .line 926
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v12, 0x0

    .line 927
    .local v12, "result":I
    const/4 v10, 0x0

    .line 929
    .local v10, "deletes":I
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 930
    const/4 v1, 0x1

    new-array v4, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v4, v1

    .line 931
    .local v4, "whereArgs":[Ljava/lang/String;
    const-string v1, "posts"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v5, "metadata_flags"

    aput-object v5, v2, v3

    const-string v3, "post_id=?"

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v8

    .line 934
    .local v8, "c":Landroid/database/Cursor;
    if-eqz v8, :cond_2

    .line 936
    :try_start_2
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 937
    new-instance v9, Landroid/content/ContentValues;

    invoke-direct {v9}, Landroid/content/ContentValues;-><init>()V

    .line 938
    .local v9, "cv":Landroid/content/ContentValues;
    const/4 v1, 0x0

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v11

    .line 939
    .local v11, "flag":I
    and-int/lit8 v11, v11, -0x9

    .line 940
    const-string v1, "metadata_flags"

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v9, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 942
    sget-boolean v1, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v1, :cond_0

    .line 943
    const-string v1, "VineDH"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Removing like in post: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 945
    :cond_0
    const-string v1, "posts"

    const-string v2, "post_id=?"

    invoke-virtual {v0, v1, v9, v2, v4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result v1

    if-lez v1, :cond_6

    const/4 v12, 0x1

    .line 949
    .end local v9    # "cv":Landroid/content/ContentValues;
    .end local v11    # "flag":I
    :cond_1
    :goto_0
    :try_start_3
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 954
    :cond_2
    const-string v1, "likes"

    const-string v2, "post_id=? AND user_id=?"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v3, v5

    const/4 v5, 0x1

    invoke-static/range {p3 .. p4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v3, v5

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v10

    .line 957
    const/4 v1, 0x3

    invoke-direct {p0, v1, p1, p2}, Lco/vine/android/provider/VineDatabaseHelper;->removePostsFromGroupByPostId(IJ)I

    move-result v1

    add-int/2addr v10, v1

    .line 958
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 959
    sget-boolean v1, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v1, :cond_3

    .line 960
    const-string v1, "VineDH"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Deleted self like for post: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 963
    :cond_3
    :try_start_4
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 965
    if-eqz p5, :cond_5

    if-gtz v12, :cond_4

    if-lez v10, :cond_5

    .line 966
    :cond_4
    invoke-direct {p0}, Lco/vine/android/provider/VineDatabaseHelper;->notifyPostCommentsViewUris()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 968
    :cond_5
    monitor-exit p0

    return v12

    .line 945
    .restart local v9    # "cv":Landroid/content/ContentValues;
    .restart local v11    # "flag":I
    :cond_6
    const/4 v12, 0x0

    goto :goto_0

    .line 949
    .end local v9    # "cv":Landroid/content/ContentValues;
    .end local v11    # "flag":I
    :catchall_0
    move-exception v1

    :try_start_5
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v1
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 963
    .end local v4    # "whereArgs":[Ljava/lang/String;
    .end local v8    # "c":Landroid/database/Cursor;
    :catchall_1
    move-exception v1

    :try_start_6
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v1
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    .line 925
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v10    # "deletes":I
    .end local v12    # "result":I
    :catchall_2
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public removeNotificationForConversation(J)V
    .locals 6
    .param p1, "conversationRowId"    # J

    .prologue
    .line 1078
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 1079
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "notifications"

    const-string v2, "conversation_row_id=?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1080
    return-void
.end method

.method public removeNotificationsForNotificationId(I)V
    .locals 6
    .param p1, "notificationId"    # I

    .prologue
    .line 1073
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 1074
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "notifications"

    const-string v2, "notification_id=?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1075
    return-void
.end method

.method public declared-synchronized removePostsByReposterId(J)V
    .locals 7
    .param p1, "reposterId"    # J

    .prologue
    .line 2341
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2342
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v3, "reposter_id=? AND post_type =?"

    .line 2343
    .local v3, "selection":Ljava/lang/String;
    const/4 v4, 0x2

    new-array v2, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x1

    const/4 v5, 0x1

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    .line 2345
    .local v2, "selArgs":[Ljava/lang/String;
    const-string v4, "post_groups"

    const-string v5, "reposter_id=? AND post_type =?"

    invoke-virtual {v0, v4, v5, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 2347
    .local v1, "deleted":I
    sget-boolean v4, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v4, :cond_0

    .line 2348
    const-string v4, "VineDH"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Deleted "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " posts with reposterId="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 2350
    :cond_0
    if-lez v1, :cond_1

    .line 2351
    iget-object v4, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v5, Lco/vine/android/provider/Vine$PostGroupsView;->CONTENT_URI:Landroid/net/Uri;

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 2352
    iget-object v4, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v5, Lco/vine/android/provider/Vine$PostCommentsLikesView;->CONTENT_URI:Landroid/net/Uri;

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 2353
    iget-object v4, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v5, Lco/vine/android/provider/Vine$PostCommentsLikesView;->CONTENT_URI_ALL_TIMELINE:Landroid/net/Uri;

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2355
    :cond_1
    monitor-exit p0

    return-void

    .line 2341
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "deleted":I
    .end local v2    # "selArgs":[Ljava/lang/String;
    .end local v3    # "selection":Ljava/lang/String;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4
.end method

.method public declared-synchronized removePostsFromGroupByUser(JILjava/lang/String;)I
    .locals 18
    .param p1, "userId"    # J
    .param p3, "type"    # I
    .param p4, "tag"    # Ljava/lang/String;

    .prologue
    .line 1355
    monitor-enter p0

    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 1356
    .local v2, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v3, "post_groups_view"

    sget-object v4, Lco/vine/android/provider/VineDatabaseSQL$PostGroupsQuery;->PROJECTION:[Ljava/lang/String;

    const-string v5, "user_id=? AND post_type=? AND tag=?"

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x1

    invoke-static/range {p3 .. p3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x2

    aput-object p4, v6, v7

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-virtual/range {v2 .. v9}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 1361
    .local v10, "c":Landroid/database/Cursor;
    new-instance v15, Ljava/util/ArrayList;

    invoke-direct {v15}, Ljava/util/ArrayList;-><init>()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 1362
    .local v15, "postIdsToRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    if-eqz v10, :cond_2

    .line 1364
    :try_start_1
    invoke-interface {v10}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1366
    :cond_0
    const/4 v3, 0x0

    invoke-interface {v10, v3}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v15, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1367
    invoke-interface {v10}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v3

    if-nez v3, :cond_0

    .line 1370
    :cond_1
    :try_start_2
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 1374
    :cond_2
    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    .line 1375
    .local v14, "placeHolderString":Ljava/lang/StringBuilder;
    invoke-virtual {v15}, Ljava/util/ArrayList;->size()I

    move-result v16

    .line 1376
    .local v16, "size":I
    const/4 v11, 0x0

    .local v11, "i":I
    :goto_0
    move/from16 v0, v16

    if-ge v11, v0, :cond_4

    .line 1377
    const-string v3, "?"

    invoke-virtual {v14, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1378
    add-int/lit8 v3, v16, -0x1

    if-ge v11, v3, :cond_3

    const/4 v3, 0x1

    move/from16 v0, v16

    if-eq v0, v3, :cond_3

    .line 1379
    const-string v3, ","

    invoke-virtual {v14, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1376
    :cond_3
    add-int/lit8 v11, v11, 0x1

    goto :goto_0

    .line 1370
    .end local v11    # "i":I
    .end local v14    # "placeHolderString":Ljava/lang/StringBuilder;
    .end local v16    # "size":I
    :catchall_0
    move-exception v3

    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    throw v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 1355
    .end local v2    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v10    # "c":Landroid/database/Cursor;
    .end local v15    # "postIdsToRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :catchall_1
    move-exception v3

    monitor-exit p0

    throw v3

    .line 1384
    .restart local v2    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v10    # "c":Landroid/database/Cursor;
    .restart local v11    # "i":I
    .restart local v14    # "placeHolderString":Ljava/lang/StringBuilder;
    .restart local v15    # "postIdsToRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .restart local v16    # "size":I
    :cond_4
    :try_start_3
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 1386
    invoke-virtual {v15}, Ljava/util/ArrayList;->size()I

    move-result v3

    new-array v12, v3, [Ljava/lang/String;

    .line 1387
    .local v12, "idArray":[Ljava/lang/String;
    invoke-static/range {p3 .. p3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v15, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1389
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, " IN ("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ") AND "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "post_type"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "=?"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    .line 1392
    .local v17, "whereString":Ljava/lang/String;
    const-string v4, "post_groups"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "post_id"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v15, v12}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Ljava/lang/String;

    invoke-virtual {v2, v4, v5, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v13

    .line 1394
    .local v13, "numGroups":I
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 1396
    sget-boolean v3, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v3, :cond_5

    .line 1397
    const-string v3, "VineDH"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Due to unfollowing "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-wide/from16 v0, p1

    invoke-virtual {v4, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " deleting "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " groups "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " , of type "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move/from16 v0, p3

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " and tag "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, p4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 1401
    :cond_5
    :try_start_4
    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 1404
    if-lez v13, :cond_6

    .line 1405
    invoke-direct/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->notifyPostCommentsViewUris()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 1408
    :cond_6
    monitor-exit p0

    return v13

    .line 1401
    .end local v12    # "idArray":[Ljava/lang/String;
    .end local v13    # "numGroups":I
    .end local v17    # "whereString":Ljava/lang/String;
    :catchall_2
    move-exception v3

    :try_start_5
    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v3
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1
.end method

.method public removeUserSectionsWithType(I)V
    .locals 6
    .param p1, "sectionType"    # I

    .prologue
    .line 3911
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3912
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "user_sections"

    const-string v2, "section_type=?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 3914
    return-void
.end method

.method public declared-synchronized removeUserWithType(JIZLandroid/net/Uri;)Z
    .locals 8
    .param p1, "userId"    # J
    .param p3, "type"    # I
    .param p4, "notify"    # Z
    .param p5, "uri"    # Landroid/net/Uri;

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 1902
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 1903
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v3, "type=? AND user_id=?"

    .line 1904
    .local v3, "selection":Ljava/lang/String;
    const/4 v6, 0x2

    new-array v2, v6, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static {p3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v2, v6

    const/4 v6, 0x1

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v2, v6

    .line 1905
    .local v2, "selArgs":[Ljava/lang/String;
    const-string v6, "user_groups"

    const-string v7, "type=? AND user_id=?"

    invoke-virtual {v0, v6, v7, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 1907
    .local v1, "deleted":I
    if-lez v1, :cond_2

    .line 1908
    if-eqz p4, :cond_0

    .line 1909
    iget-object v5, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    const/4 v6, 0x0

    invoke-virtual {v5, p5, v6}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 1911
    :cond_0
    sget-boolean v5, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v5, :cond_1

    .line 1912
    const-string v5, "VineDH"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Deleted user with userId="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " of type="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1916
    :cond_1
    :goto_0
    monitor-exit p0

    return v4

    :cond_2
    move v4, v5

    goto :goto_0

    .line 1902
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "deleted":I
    .end local v2    # "selArgs":[Ljava/lang/String;
    .end local v3    # "selection":Ljava/lang/String;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4
.end method

.method public declared-synchronized removeUsersByGroup(I)V
    .locals 7
    .param p1, "type"    # I

    .prologue
    .line 2328
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2329
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v2, "user_groups"

    const-string v3, "type=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v0, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 2332
    .local v1, "deleted":I
    sget-boolean v2, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v2, :cond_0

    .line 2333
    const-string v2, "VineDH"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Deleted "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " users of type "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2335
    :cond_0
    monitor-exit p0

    return-void

    .line 2328
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "deleted":I
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized revine(Lco/vine/android/api/VineRepost;JZ)I
    .locals 20
    .param p1, "repost"    # Lco/vine/android/api/VineRepost;
    .param p2, "userId"    # J
    .param p4, "notify"    # Z

    .prologue
    .line 978
    monitor-enter p0

    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    move-result-object v1

    .line 979
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/16 v19, 0x0

    .line 982
    .local v19, "result":I
    :try_start_1
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 983
    const/4 v2, 0x1

    new-array v5, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    move-object/from16 v0, p1

    iget-wide v3, v0, Lco/vine/android/api/VineRepost;->postId:J

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v5, v2

    .line 984
    .local v5, "whereArgs":[Ljava/lang/String;
    const-string v2, "posts"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v6, "metadata_flags"

    aput-object v6, v3, v4

    const-string v4, "post_id=?"

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v14

    .line 987
    .local v14, "c":Landroid/database/Cursor;
    if-eqz v14, :cond_2

    .line 989
    :try_start_2
    invoke-interface {v14}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-lez v2, :cond_1

    invoke-interface {v14}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 990
    new-instance v17, Landroid/content/ContentValues;

    invoke-direct/range {v17 .. v17}, Landroid/content/ContentValues;-><init>()V

    .line 991
    .local v17, "cv":Landroid/content/ContentValues;
    const/4 v2, 0x0

    invoke-interface {v14, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v18

    .line 992
    .local v18, "flag":I
    or-int/lit8 v18, v18, 0x10

    .line 993
    const-string v2, "metadata_flags"

    invoke-static/range {v18 .. v18}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 994
    const-string v2, "my_repost_id"

    move-object/from16 v0, p1

    iget-wide v3, v0, Lco/vine/android/api/VineRepost;->repostId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 995
    invoke-interface {v14}, Landroid/database/Cursor;->close()V

    .line 996
    sget-boolean v2, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v2, :cond_0

    .line 997
    const-string v2, "VineDH"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Revined post "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p1

    iget-wide v6, v0, Lco/vine/android/api/VineRepost;->postId:J

    invoke-virtual {v3, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 999
    :cond_0
    const-string v2, "posts"

    const-string v3, "post_id=?"

    move-object/from16 v0, v17

    invoke-virtual {v1, v2, v0, v3, v5}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result v2

    if-lez v2, :cond_6

    const/16 v19, 0x1

    .line 1004
    .end local v17    # "cv":Landroid/content/ContentValues;
    .end local v18    # "flag":I
    :cond_1
    :goto_0
    :try_start_3
    invoke-interface {v14}, Landroid/database/Cursor;->close()V

    .line 1009
    :cond_2
    const-string v7, "post_groups"

    const/4 v2, 0x1

    new-array v8, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "repost_data"

    aput-object v3, v8, v2

    const-string v9, "post_id=? AND post_type=? AND tag=?"

    const/4 v2, 0x3

    new-array v10, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    move-object/from16 v0, p1

    iget-wide v3, v0, Lco/vine/android/api/VineRepost;->postId:J

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v10, v2

    const/4 v2, 0x1

    const/4 v3, 0x2

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v10, v2

    const/4 v2, 0x2

    invoke-static/range {p2 .. p3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v10, v2

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    move-object v6, v1

    invoke-virtual/range {v6 .. v13}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    move-result-object v15

    .line 1018
    .local v15, "c2":Landroid/database/Cursor;
    if-eqz v15, :cond_4

    .line 1020
    :try_start_4
    invoke-interface {v15}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-lez v2, :cond_8

    invoke-interface {v15}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_8

    .line 1022
    const/4 v2, 0x0

    invoke-interface {v15, v2}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v2

    invoke-static {v2}, Lco/vine/android/util/Util;->fromByteArray([B)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lco/vine/android/api/VineRepost;

    .line 1023
    .local v16, "currentData":Lco/vine/android/api/VineRepost;
    if-eqz v16, :cond_7

    .line 1024
    move-object/from16 v0, p1

    iget-wide v2, v0, Lco/vine/android/api/VineRepost;->repostId:J

    move-object/from16 v0, v16

    iput-wide v2, v0, Lco/vine/android/api/VineRepost;->repostId:J

    .line 1030
    :goto_1
    new-instance v17, Landroid/content/ContentValues;

    invoke-direct/range {v17 .. v17}, Landroid/content/ContentValues;-><init>()V

    .line 1031
    .restart local v17    # "cv":Landroid/content/ContentValues;
    const-string v2, "repost_data"

    invoke-static/range {v16 .. v16}, Lco/vine/android/util/Util;->toByteArray(Ljava/lang/Object;)[B

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;[B)V

    .line 1032
    const-string v2, "sort_id"

    move-object/from16 v0, p1

    iget-wide v3, v0, Lco/vine/android/api/VineRepost;->repostId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1033
    const-string v2, "post_groups"

    const-string v3, "post_id=? AND post_type=? AND tag=?"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/String;

    const/4 v6, 0x0

    move-object/from16 v0, p1

    iget-wide v7, v0, Lco/vine/android/api/VineRepost;->postId:J

    invoke-static {v7, v8}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v6

    const/4 v6, 0x1

    const/4 v7, 0x2

    invoke-static {v7}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v6

    const/4 v6, 0x2

    invoke-static/range {p2 .. p3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v6

    move-object/from16 v0, v17

    invoke-virtual {v1, v2, v0, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1039
    sget-boolean v2, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v2, :cond_3

    .line 1040
    const-string v2, "VineDH"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Updated repost data for post "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, v16

    iget-wide v6, v0, Lco/vine/android/api/VineRepost;->postId:J

    invoke-virtual {v3, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " with repost id "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, v16

    iget-wide v6, v0, Lco/vine/android/api/VineRepost;->repostId:J

    invoke-virtual {v3, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " for user timeline."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    .line 1059
    .end local v16    # "currentData":Lco/vine/android/api/VineRepost;
    :cond_3
    :goto_2
    :try_start_5
    invoke-interface {v15}, Landroid/database/Cursor;->close()V

    .line 1062
    .end local v17    # "cv":Landroid/content/ContentValues;
    :cond_4
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 1064
    :try_start_6
    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 1066
    if-eqz p4, :cond_5

    if-lez v19, :cond_5

    .line 1067
    invoke-direct/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->notifyPostCommentsViewUris()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    .line 1069
    :cond_5
    monitor-exit p0

    return v19

    .line 999
    .end local v15    # "c2":Landroid/database/Cursor;
    .restart local v17    # "cv":Landroid/content/ContentValues;
    .restart local v18    # "flag":I
    :cond_6
    const/16 v19, 0x0

    goto/16 :goto_0

    .line 1004
    .end local v17    # "cv":Landroid/content/ContentValues;
    .end local v18    # "flag":I
    :catchall_0
    move-exception v2

    :try_start_7
    invoke-interface {v14}, Landroid/database/Cursor;->close()V

    throw v2
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .line 1064
    .end local v5    # "whereArgs":[Ljava/lang/String;
    .end local v14    # "c":Landroid/database/Cursor;
    :catchall_1
    move-exception v2

    :try_start_8
    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v2
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_2

    .line 978
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v19    # "result":I
    :catchall_2
    move-exception v2

    monitor-exit p0

    throw v2

    .line 1026
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v5    # "whereArgs":[Ljava/lang/String;
    .restart local v14    # "c":Landroid/database/Cursor;
    .restart local v15    # "c2":Landroid/database/Cursor;
    .restart local v16    # "currentData":Lco/vine/android/api/VineRepost;
    .restart local v19    # "result":I
    :cond_7
    :try_start_9
    new-instance v16, Lco/vine/android/api/VineRepost;

    .end local v16    # "currentData":Lco/vine/android/api/VineRepost;
    invoke-direct/range {v16 .. v16}, Lco/vine/android/api/VineRepost;-><init>()V

    .line 1027
    .restart local v16    # "currentData":Lco/vine/android/api/VineRepost;
    move-object/from16 v0, p1

    iget-wide v2, v0, Lco/vine/android/api/VineRepost;->repostId:J

    move-object/from16 v0, v16

    iput-wide v2, v0, Lco/vine/android/api/VineRepost;->repostId:J

    .line 1028
    move-object/from16 v0, p1

    iget-wide v2, v0, Lco/vine/android/api/VineRepost;->postId:J

    move-object/from16 v0, v16

    iput-wide v2, v0, Lco/vine/android/api/VineRepost;->postId:J
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_3

    goto/16 :goto_1

    .line 1059
    .end local v16    # "currentData":Lco/vine/android/api/VineRepost;
    :catchall_3
    move-exception v2

    :try_start_a
    invoke-interface {v15}, Landroid/database/Cursor;->close()V

    throw v2
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    .line 1046
    :cond_8
    :try_start_b
    new-instance v17, Landroid/content/ContentValues;

    invoke-direct/range {v17 .. v17}, Landroid/content/ContentValues;-><init>()V

    .line 1047
    .restart local v17    # "cv":Landroid/content/ContentValues;
    const-string v2, "post_type"

    const/4 v3, 0x2

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1048
    const-string v2, "post_id"

    move-object/from16 v0, p1

    iget-wide v3, v0, Lco/vine/android/api/VineRepost;->postId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1049
    const-string v2, "sort_id"

    move-object/from16 v0, p1

    iget-wide v3, v0, Lco/vine/android/api/VineRepost;->repostId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1050
    const-string v2, "tag"

    invoke-static/range {p2 .. p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1051
    const-string v2, "repost_data"

    invoke-static/range {p1 .. p1}, Lco/vine/android/util/Util;->toByteArray(Ljava/lang/Object;)[B

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;[B)V

    .line 1052
    const-string v2, "post_groups"

    const-string v3, "post_id"

    move-object/from16 v0, v17

    invoke-virtual {v1, v2, v3, v0}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 1053
    sget-boolean v2, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v2, :cond_3

    .line 1054
    const-string v2, "VineDH"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Inserted repost data for post "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p1

    iget-wide v6, v0, Lco/vine/android/api/VineRepost;->postId:J

    invoke-virtual {v3, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " with repost id "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p1

    iget-wide v6, v0, Lco/vine/android/api/VineRepost;->repostId:J

    invoke-virtual {v3, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " for user timeline."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_3

    goto/16 :goto_2
.end method

.method public safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 12
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 3256
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 3258
    :try_start_0
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteDiskIOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/database/sqlite/SQLiteFullException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_5

    .line 3287
    :cond_0
    :goto_0
    return-void

    .line 3259
    :catch_0
    move-exception v2

    .line 3260
    .local v2, "e":Landroid/database/sqlite/SQLiteDiskIOException;
    throw v2

    .line 3261
    .end local v2    # "e":Landroid/database/sqlite/SQLiteDiskIOException;
    :catch_1
    move-exception v2

    .line 3262
    .local v2, "e":Landroid/database/sqlite/SQLiteFullException;
    const-wide/16 v0, -0x1

    .line 3264
    .local v0, "currentSize":J
    :try_start_1
    iget-object v4, p0, Lco/vine/android/provider/VineDatabaseHelper;->mAppContext:Landroid/content/Context;

    invoke-static {v4}, Lco/vine/android/util/Util;->getCacheSize(Landroid/content/Context;)J
    :try_end_1
    .catch Lco/vine/android/VineLoggingException; {:try_start_1 .. :try_end_1} :catch_2

    move-result-wide v0

    .line 3268
    :goto_1
    iget-object v4, p0, Lco/vine/android/provider/VineDatabaseHelper;->mAppContext:Landroid/content/Context;

    invoke-static {v4}, Lco/vine/android/client/AppController;->clearFileCache(Landroid/content/Context;)V

    .line 3270
    :try_start_2
    new-instance v4, Lco/vine/android/VineLoggingException;

    invoke-direct {v4}, Lco/vine/android/VineLoggingException;-><init>()V

    const-string v5, "Db full, cleaned cache from {} to {}."

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x1

    iget-object v8, p0, Lco/vine/android/provider/VineDatabaseHelper;->mAppContext:Landroid/content/Context;

    invoke-static {v8}, Lco/vine/android/util/Util;->getCacheSize(Landroid/content/Context;)J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v4, v5, v6}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_2
    .catch Lco/vine/android/VineLoggingException; {:try_start_2 .. :try_end_2} :catch_3

    .line 3274
    :goto_2
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 3275
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    goto :goto_0

    .line 3265
    :catch_2
    move-exception v3

    .line 3266
    .local v3, "e2":Lco/vine/android/VineLoggingException;
    invoke-static {v2}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_1

    .line 3271
    .end local v3    # "e2":Lco/vine/android/VineLoggingException;
    :catch_3
    move-exception v3

    .line 3272
    .restart local v3    # "e2":Lco/vine/android/VineLoggingException;
    new-instance v4, Lco/vine/android/VineLoggingException;

    invoke-direct {v4}, Lco/vine/android/VineLoggingException;-><init>()V

    const-string v5, "Db full, cleaned cache from {} to unknown."

    new-array v6, v11, [Ljava/lang/Object;

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v6, v10

    invoke-static {v4, v5, v6}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2

    .line 3277
    .end local v0    # "currentSize":J
    .end local v2    # "e":Landroid/database/sqlite/SQLiteFullException;
    .end local v3    # "e2":Lco/vine/android/VineLoggingException;
    :catch_4
    move-exception v2

    .line 3278
    .local v2, "e":Landroid/database/sqlite/SQLiteException;
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteException;->getMessage()Ljava/lang/String;

    move-result-object v4

    const-string v5, "(code 1)"

    invoke-virtual {v4, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 3279
    throw v2

    .line 3281
    .end local v2    # "e":Landroid/database/sqlite/SQLiteException;
    :catch_5
    move-exception v2

    .line 3282
    .local v2, "e":Ljava/lang/IllegalStateException;
    invoke-virtual {v2}, Ljava/lang/IllegalStateException;->getMessage()Ljava/lang/String;

    move-result-object v4

    const-string v5, "already-closed"

    invoke-virtual {v4, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 3283
    throw v2
.end method

.method public declared-synchronized savePageCursor(IILjava/lang/String;IIJZ)I
    .locals 14
    .param p1, "kind"    # I
    .param p2, "type"    # I
    .param p3, "tag"    # Ljava/lang/String;
    .param p4, "nextPage"    # I
    .param p5, "prevPage"    # I
    .param p6, "anchor"    # J
    .param p8, "reversed"    # Z

    .prologue
    .line 2654
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 2656
    .local v2, "db":Landroid/database/sqlite/SQLiteDatabase;
    if-nez p3, :cond_0

    .line 2657
    const-string p3, ""

    .line 2660
    :cond_0
    const-string v12, "kind=? AND type=? AND tag=?"

    .line 2661
    .local v12, "projection":Ljava/lang/String;
    const/4 v3, 0x3

    new-array v6, v3, [Ljava/lang/String;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v6, v3

    const/4 v3, 0x1

    invoke-static/range {p2 .. p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v6, v3

    const/4 v3, 0x2

    aput-object p3, v6, v3

    .line 2664
    .local v6, "selectionArgs":[Ljava/lang/String;
    const-string v3, "page_cursors"

    sget-object v4, Lco/vine/android/provider/VineDatabaseSQL$PageCursorsQuery;->PROJECTION:[Ljava/lang/String;

    const-string v5, "kind=? AND type=? AND tag=?"

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-virtual/range {v2 .. v9}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 2667
    .local v10, "c":Landroid/database/Cursor;
    new-instance v13, Landroid/content/ContentValues;

    invoke-direct {v13}, Landroid/content/ContentValues;-><init>()V

    .line 2668
    .local v13, "values":Landroid/content/ContentValues;
    const-string v3, "kind"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v13, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2669
    const-string v3, "type"

    invoke-static/range {p2 .. p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v13, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2670
    const-string v3, "tag"

    move-object/from16 v0, p3

    invoke-virtual {v13, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2671
    const-string v3, "next_page"

    invoke-static/range {p4 .. p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v13, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2672
    const-string v3, "previous_page"

    invoke-static/range {p5 .. p5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v13, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2673
    const-string v3, "anchor"

    invoke-static/range {p6 .. p7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v13, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2674
    const-string v3, "reversed"

    invoke-static/range {p8 .. p8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v13, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 2676
    const/4 v11, 0x0

    .line 2677
    .local v11, "num":I
    if-eqz v10, :cond_5

    .line 2679
    :try_start_1
    invoke-interface {v10}, Landroid/database/Cursor;->getCount()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_3

    .line 2680
    const-string v3, "page_cursors"

    const-string v4, "kind=? AND type=? AND tag=?"

    invoke-virtual {v2, v3, v13, v4, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v3

    if-lez v3, :cond_2

    const/4 v3, 0x1

    :goto_0
    add-int/2addr v11, v3

    .line 2687
    :goto_1
    :try_start_2
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 2692
    :goto_2
    sget-boolean v3, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v3, :cond_1

    .line 2693
    if-lez v11, :cond_1

    .line 2694
    const-string v3, "VineDH"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Saved pagecursor of kind: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " type: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move/from16 v0, p2

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " tag: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, p3

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " next:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move/from16 v0, p4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " prev: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move/from16 v0, p5

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " anchor: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-wide/from16 v0, p6

    invoke-virtual {v4, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " reverse: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move/from16 v0, p8

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2699
    :cond_1
    monitor-exit p0

    return v11

    .line 2680
    :cond_2
    const/4 v3, 0x0

    goto :goto_0

    .line 2683
    :cond_3
    :try_start_3
    const-string v3, "page_cursors"

    const-string v4, "_id"

    invoke-virtual {v2, v3, v4, v13}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-wide v3

    const-wide/16 v7, 0x0

    cmp-long v3, v3, v7

    if-lez v3, :cond_4

    const/4 v3, 0x1

    :goto_3
    add-int/2addr v11, v3

    goto :goto_1

    :cond_4
    const/4 v3, 0x0

    goto :goto_3

    .line 2687
    :catchall_0
    move-exception v3

    :try_start_4
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    throw v3
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 2654
    .end local v2    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v6    # "selectionArgs":[Ljava/lang/String;
    .end local v10    # "c":Landroid/database/Cursor;
    .end local v11    # "num":I
    .end local v12    # "projection":Ljava/lang/String;
    .end local v13    # "values":Landroid/content/ContentValues;
    :catchall_1
    move-exception v3

    monitor-exit p0

    throw v3

    .line 2690
    .restart local v2    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v6    # "selectionArgs":[Ljava/lang/String;
    .restart local v10    # "c":Landroid/database/Cursor;
    .restart local v11    # "num":I
    .restart local v12    # "projection":Ljava/lang/String;
    .restart local v13    # "values":Landroid/content/ContentValues;
    :cond_5
    :try_start_5
    const-string v3, "page_cursors"

    const-string v4, "_id"

    invoke-virtual {v2, v3, v4, v13}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    move-result-wide v3

    const-wide/16 v7, 0x0

    cmp-long v3, v3, v7

    if-lez v3, :cond_6

    const/4 v3, 0x1

    :goto_4
    add-int/2addr v11, v3

    goto/16 :goto_2

    :cond_6
    const/4 v3, 0x0

    goto :goto_4
.end method

.method public declared-synchronized saveUserValue(Ljava/lang/String;Landroid/content/ContentValues;)I
    .locals 7
    .param p1, "propName"    # Ljava/lang/String;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 2636
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 2637
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v3, "settings"

    const-string v4, "name=?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    aput-object p1, v5, v6

    invoke-virtual {v0, v3, p2, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_0

    .line 2640
    const-string v3, "name"

    invoke-virtual {p2, v3, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2641
    const-string v3, "settings"

    const-string v4, "name"

    invoke-virtual {v0, v3, v4, p2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v3

    const-wide/16 v5, 0x0

    cmp-long v3, v3, v5

    if-nez v3, :cond_0

    .line 2649
    :goto_0
    monitor-exit p0

    return v1

    .line 2645
    :cond_0
    :try_start_1
    iget-object v1, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    if-nez v1, :cond_1

    .line 2646
    iget-object v1, p0, Lco/vine/android/provider/VineDatabaseHelper;->mAppContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    .line 2648
    :cond_1
    iget-object v1, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v3, Lco/vine/android/provider/Vine$Settings;->CONTENT_URI:Landroid/net/Uri;

    const/4 v4, 0x0

    invoke-virtual {v1, v3, v4}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move v1, v2

    .line 2649
    goto :goto_0

    .line 2636
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public setConversationHidden(JZ)V
    .locals 8
    .param p1, "conversationRowId"    # J
    .param p3, "hidden"    # Z

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 3470
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 3471
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 3472
    .local v0, "cv":Landroid/content/ContentValues;
    const-string v6, "is_hidden"

    if-eqz p3, :cond_0

    move v3, v4

    :goto_0
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v6, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3473
    const-string v3, "conversations"

    const-string v6, "_id=?"

    new-array v4, v4, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v5

    invoke-virtual {v1, v3, v0, v6, v4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    .line 3474
    .local v2, "updated":I
    const-string v3, "VineDH"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Marked conversation "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " hidden value "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p3}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " updated rows: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 3475
    return-void

    .end local v2    # "updated":I
    :cond_0
    move v3, v5

    .line 3472
    goto :goto_0
.end method

.method public setMessageError(JILjava/lang/String;)V
    .locals 8
    .param p1, "messageRowId"    # J
    .param p3, "errorCode"    # I
    .param p4, "errorReason"    # Ljava/lang/String;

    .prologue
    .line 3863
    const-wide/16 v3, 0x0

    cmp-long v3, p1, v3

    if-lez v3, :cond_0

    .line 3864
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 3865
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 3866
    .local v0, "cv":Landroid/content/ContentValues;
    const-string v3, "error_code"

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3867
    const-string v3, "error_reason"

    invoke-virtual {v0, v3, p4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3868
    const-string v3, "messages"

    const-string v4, "_id=?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v1, v3, v0, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    .line 3871
    .local v2, "updated":I
    if-lez v2, :cond_0

    .line 3872
    invoke-direct {p0}, Lco/vine/android/provider/VineDatabaseHelper;->notifyVMUris()V

    .line 3875
    .end local v0    # "cv":Landroid/content/ContentValues;
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v2    # "updated":I
    :cond_0
    return-void
.end method

.method public setMessageError(Ljava/lang/String;ILjava/lang/String;)V
    .locals 7
    .param p1, "uploadPath"    # Ljava/lang/String;
    .param p2, "errorCode"    # I
    .param p3, "errorReason"    # Ljava/lang/String;

    .prologue
    .line 3848
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 3849
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 3850
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 3851
    .local v0, "cv":Landroid/content/ContentValues;
    const-string v3, "error_code"

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3852
    const-string v3, "error_reason"

    invoke-virtual {v0, v3, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3853
    const-string v3, "messages"

    const-string v4, "upload_path=?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    aput-object p1, v5, v6

    invoke-virtual {v1, v3, v0, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    .line 3856
    .local v2, "updated":I
    if-lez v2, :cond_0

    .line 3857
    invoke-direct {p0}, Lco/vine/android/provider/VineDatabaseHelper;->notifyVMUris()V

    .line 3860
    .end local v0    # "cv":Landroid/content/ContentValues;
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v2    # "updated":I
    :cond_0
    return-void
.end method

.method public setShouldHideProfileRevines(JZ)Z
    .locals 9
    .param p1, "userId"    # J
    .param p3, "hide"    # Z

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 3021
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3023
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v2, "user_id=?"

    .line 3024
    .local v2, "selection":Ljava/lang/String;
    new-array v1, v6, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v1, v7

    .line 3025
    .local v1, "selArgs":[Ljava/lang/String;
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    .line 3026
    .local v4, "values":Landroid/content/ContentValues;
    const-string v8, "hide_profile_reposts"

    if-eqz p3, :cond_0

    move v5, v6

    :goto_0
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v8, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3028
    const/4 v3, 0x0

    .line 3029
    .local v3, "updated":I
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 3031
    :try_start_0
    const-string v5, "users"

    const-string v8, "user_id=?"

    invoke-virtual {v0, v5, v4, v8, v1}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v3

    .line 3032
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 3034
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 3037
    if-lez v3, :cond_1

    :goto_1
    return v6

    .end local v3    # "updated":I
    :cond_0
    move v5, v7

    .line 3026
    goto :goto_0

    .line 3034
    .restart local v3    # "updated":I
    :catchall_0
    move-exception v5

    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v5

    :cond_1
    move v6, v7

    .line 3037
    goto :goto_1
.end method

.method public shouldHideProfileRevines(J)Z
    .locals 13
    .param p1, "userId"    # J

    .prologue
    const/4 v5, 0x0

    const/4 v11, 0x1

    const/4 v12, 0x0

    .line 2999
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3000
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v9, 0x0

    .line 3001
    .local v9, "ret":Z
    const-string v10, "user_id=?"

    .line 3002
    .local v10, "selection":Ljava/lang/String;
    new-array v4, v11, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v12

    .line 3004
    .local v4, "selArgs":[Ljava/lang/String;
    const-string v1, "users"

    new-array v2, v11, [Ljava/lang/String;

    const-string v3, "hide_profile_reposts"

    aput-object v3, v2, v12

    const-string v3, "user_id=?"

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 3008
    .local v8, "cursor":Landroid/database/Cursor;
    if-eqz v8, :cond_1

    .line 3010
    :try_start_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 3011
    const/4 v1, 0x0

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getInt(I)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-lez v1, :cond_2

    move v9, v11

    .line 3014
    :cond_0
    :goto_0
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 3017
    :cond_1
    return v9

    :cond_2
    move v9, v12

    .line 3011
    goto :goto_0

    .line 3014
    :catchall_0
    move-exception v1

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method public declared-synchronized unRevine(JJZZ)I
    .locals 26
    .param p1, "postId"    # J
    .param p3, "userId"    # J
    .param p5, "following"    # Z
    .param p6, "notify"    # Z

    .prologue
    .line 1206
    monitor-enter p0

    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    move-result-object v3

    .line 1207
    .local v3, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/16 v25, 0x0

    .line 1208
    .local v25, "result":I
    const/16 v18, 0x0

    .line 1210
    .local v18, "deletedGroups":I
    :try_start_1
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 1211
    const/4 v4, 0x1

    new-array v7, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v7, v4

    .line 1212
    .local v7, "whereArgs":[Ljava/lang/String;
    const-string v4, "posts"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    const-string v8, "metadata_flags"

    aput-object v8, v5, v6

    const-string v6, "post_id=?"

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-virtual/range {v3 .. v10}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v16

    .line 1215
    .local v16, "c":Landroid/database/Cursor;
    if-eqz v16, :cond_2

    .line 1217
    :try_start_2
    invoke-interface/range {v16 .. v16}, Landroid/database/Cursor;->getCount()I

    move-result v4

    if-lez v4, :cond_1

    invoke-interface/range {v16 .. v16}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 1218
    new-instance v17, Landroid/content/ContentValues;

    invoke-direct/range {v17 .. v17}, Landroid/content/ContentValues;-><init>()V

    .line 1219
    .local v17, "cv":Landroid/content/ContentValues;
    const/4 v4, 0x0

    move-object/from16 v0, v16

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v19

    .line 1220
    .local v19, "flag":I
    and-int/lit8 v19, v19, -0x11

    .line 1221
    const-string v4, "metadata_flags"

    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    move-object/from16 v0, v17

    invoke-virtual {v0, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1222
    const-string v4, "my_repost_id"

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    move-object/from16 v0, v17

    invoke-virtual {v0, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1223
    sget-boolean v4, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v4, :cond_0

    .line 1224
    const-string v4, "VineDH"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Unrevined post "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-wide/from16 v0, p1

    invoke-virtual {v5, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1226
    :cond_0
    const-string v4, "posts"

    const-string v5, "post_id=?"

    move-object/from16 v0, v17

    invoke-virtual {v3, v4, v0, v5, v7}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result v4

    if-lez v4, :cond_8

    const/16 v25, 0x1

    .line 1230
    .end local v17    # "cv":Landroid/content/ContentValues;
    .end local v19    # "flag":I
    :cond_1
    :goto_0
    :try_start_3
    invoke-interface/range {v16 .. v16}, Landroid/database/Cursor;->close()V

    .line 1233
    :cond_2
    const-string v4, "post_groups"

    const-string v5, "post_id=? AND post_type=? AND tag=?"

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/String;

    const/4 v8, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v6, v8

    const/4 v8, 0x1

    const/4 v9, 0x2

    invoke-static {v9}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v6, v8

    const/4 v8, 0x2

    invoke-static/range {p3 .. p4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v6, v8

    invoke-virtual {v3, v4, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v18

    .line 1239
    sget-boolean v4, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v4, :cond_3

    .line 1240
    const-string v4, "VineDH"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Deleted "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move/from16 v0, v18

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " with tag "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-wide/from16 v0, p3

    invoke-virtual {v5, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " and type "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const/4 v6, 0x2

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " and post id "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-wide/from16 v0, p1

    invoke-virtual {v5, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " due to unrevining."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1245
    :cond_3
    if-nez p5, :cond_5

    .line 1247
    const-string v9, "posts"

    const/4 v4, 0x1

    new-array v10, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "user_id"

    aput-object v5, v10, v4

    const-string v11, "post_id=?"

    const/4 v4, 0x1

    new-array v12, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v12, v4

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    move-object v8, v3

    invoke-virtual/range {v8 .. v15}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    move-result-object v16

    .line 1248
    if-eqz v16, :cond_5

    .line 1250
    :try_start_4
    invoke-interface/range {v16 .. v16}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v4

    if-eqz v4, :cond_4

    .line 1251
    const/4 v4, 0x0

    move-object/from16 v0, v16

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v20

    .line 1252
    .local v20, "postUserId":J
    move-object/from16 v0, p0

    move-wide/from16 v1, v20

    invoke-virtual {v0, v1, v2}, Lco/vine/android/provider/VineDatabaseHelper;->getUserRowIdForUserRemoteId(J)J

    move-result-wide v22

    .line 1253
    .local v22, "postUserRowId":J
    move-object/from16 v0, p0

    move-wide/from16 v1, v22

    invoke-virtual {v0, v1, v2}, Lco/vine/android/provider/VineDatabaseHelper;->amFollowingUser(J)Z
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    move-result p5

    .line 1256
    .end local v20    # "postUserId":J
    .end local v22    # "postUserRowId":J
    :cond_4
    :try_start_5
    invoke-interface/range {v16 .. v16}, Landroid/database/Cursor;->close()V

    .line 1261
    :cond_5
    if-nez p5, :cond_9

    .line 1263
    const-string v4, "post_groups"

    const-string v5, "post_id=? AND post_type=?"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/String;

    const/4 v8, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v6, v8

    const/4 v8, 0x1

    const/4 v9, 0x1

    invoke-static {v9}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v6, v8

    invoke-virtual {v3, v4, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v4

    add-int v18, v18, v4

    .line 1268
    sget-boolean v4, Lco/vine/android/provider/VineDatabaseHelper;->LOGGABLE:Z

    if-eqz v4, :cond_6

    .line 1269
    const-string v4, "VineDH"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Deleted "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move/from16 v0, v18

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " for type "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const/4 v6, 0x1

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " and post id "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-wide/from16 v0, p1

    invoke-virtual {v5, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " due to unrevining."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1285
    :cond_6
    :goto_1
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 1287
    :try_start_6
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 1289
    if-eqz p6, :cond_7

    .line 1290
    invoke-direct/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->notifyPostCommentsViewUris()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    .line 1292
    :cond_7
    monitor-exit p0

    return v25

    .line 1226
    .restart local v17    # "cv":Landroid/content/ContentValues;
    .restart local v19    # "flag":I
    :cond_8
    const/16 v25, 0x0

    goto/16 :goto_0

    .line 1230
    .end local v17    # "cv":Landroid/content/ContentValues;
    .end local v19    # "flag":I
    :catchall_0
    move-exception v4

    :try_start_7
    invoke-interface/range {v16 .. v16}, Landroid/database/Cursor;->close()V

    throw v4
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .line 1287
    .end local v7    # "whereArgs":[Ljava/lang/String;
    .end local v16    # "c":Landroid/database/Cursor;
    :catchall_1
    move-exception v4

    :try_start_8
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v4
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_2

    .line 1206
    .end local v3    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v18    # "deletedGroups":I
    .end local v25    # "result":I
    :catchall_2
    move-exception v4

    monitor-exit p0

    throw v4

    .line 1256
    .restart local v3    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v7    # "whereArgs":[Ljava/lang/String;
    .restart local v16    # "c":Landroid/database/Cursor;
    .restart local v18    # "deletedGroups":I
    .restart local v25    # "result":I
    :catchall_3
    move-exception v4

    :try_start_9
    invoke-interface/range {v16 .. v16}, Landroid/database/Cursor;->close()V

    throw v4

    .line 1274
    :cond_9
    new-instance v17, Landroid/content/ContentValues;

    invoke-direct/range {v17 .. v17}, Landroid/content/ContentValues;-><init>()V

    .line 1275
    .restart local v17    # "cv":Landroid/content/ContentValues;
    const-string v4, "repost_data"

    move-object/from16 v0, v17

    invoke-virtual {v0, v4}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V

    .line 1276
    const-string v4, "post_groups"

    const-string v5, "post_id=? AND post_type=?"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/String;

    const/4 v8, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v6, v8

    const/4 v8, 0x1

    const/4 v9, 0x1

    invoke-static {v9}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v6, v8

    move-object/from16 v0, v17

    invoke-virtual {v3, v4, v0, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v24

    .line 1279
    .local v24, "r":I
    const-string v4, "VineDH"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Removed   "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move/from16 v0, v24

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " repost data for type "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const/4 v6, 0x1

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " and post id "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-wide/from16 v0, p1

    invoke-virtual {v5, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " due to unrevining."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    goto/16 :goto_1
.end method

.method public declared-synchronized updateConversationWithLastMessage(JJJ)V
    .locals 8
    .param p1, "conversationRowId"    # J
    .param p3, "messageRowId"    # J
    .param p5, "created"    # J

    .prologue
    .line 2166
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v0

    .line 2167
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v1, 0x0

    .line 2169
    .local v1, "updated":I
    :try_start_1
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 2170
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 2171
    .local v2, "values":Landroid/content/ContentValues;
    const-string v3, "last_message"

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2172
    const-string v3, "last_message_timestamp"

    invoke-static {p5, p6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2173
    const-string v3, "conversations"

    const-string v4, "_id=? "

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v0, v3, v2, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 2175
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2177
    :try_start_2
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 2179
    if-lez v1, :cond_0

    .line 2180
    iget-object v3, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v4, Lco/vine/android/provider/Vine$InboxView;->CONTENT_URI:Landroid/net/Uri;

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 2181
    iget-object v3, p0, Lco/vine/android/provider/VineDatabaseHelper;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v4, Lco/vine/android/provider/Vine$Conversations;->CONTENT_URI:Landroid/net/Uri;

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2183
    :cond_0
    monitor-exit p0

    return-void

    .line 2177
    .end local v2    # "values":Landroid/content/ContentValues;
    :catchall_0
    move-exception v3

    :try_start_3
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 2166
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v1    # "updated":I
    :catchall_1
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public declared-synchronized updateMessageLoopStartTime(JJ)V
    .locals 10
    .param p1, "localStartTime"    # J
    .param p3, "messageId"    # J

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 3319
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3321
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 3324
    :try_start_1
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 3325
    .local v2, "values":Landroid/content/ContentValues;
    const-string v5, "local_start_time"

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v2, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3326
    const-string v5, "messages"

    const-string v6, "message_id=?"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    invoke-static {p3, p4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-virtual {v0, v5, v2, v6, v7}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 3328
    .local v1, "r":I
    sget-boolean v5, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v5, :cond_0

    .line 3329
    const-string v5, "Updated {} local start time to {} ? {}."

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    if-ne v1, v3, :cond_1

    :goto_0
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-static {v5, v6, v7, v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 3331
    :cond_0
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 3333
    :try_start_2
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 3335
    monitor-exit p0

    return-void

    :cond_1
    move v3, v4

    .line 3329
    goto :goto_0

    .line 3333
    .end local v1    # "r":I
    .end local v2    # "values":Landroid/content/ContentValues;
    :catchall_0
    move-exception v3

    :try_start_3
    invoke-virtual {p0, v0}, Lco/vine/android/provider/VineDatabaseHelper;->safeFinishTransaction(Landroid/database/sqlite/SQLiteDatabase;)V

    throw v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 3319
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :catchall_1
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public updateUserFollowingFlag(JZ)V
    .locals 7
    .param p1, "userIdToFollow"    # J
    .param p3, "following"    # Z

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 3934
    invoke-virtual {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 3935
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 3936
    .local v1, "values":Landroid/content/ContentValues;
    const-string v5, "following_flag"

    if-eqz p3, :cond_0

    move v2, v3

    :goto_0
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v5, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3937
    const-string v2, "users"

    const-string v5, "user_id=?"

    new-array v3, v3, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v3, v4

    invoke-virtual {v0, v2, v1, v5, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 3938
    return-void

    :cond_0
    move v2, v4

    .line 3936
    goto :goto_0
.end method
