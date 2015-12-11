.class public abstract Lco/vine/android/client/AppSessionListener;
.super Ljava/lang/Object;
.source "AppSessionListener.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAbortAllRequestsComplete()V
    .locals 0

    .prologue
    .line 403
    return-void
.end method

.method public onBlockUserComplete(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "userBlocked"    # Z

    .prologue
    .line 239
    return-void
.end method

.method public onBulkFollowComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 148
    return-void
.end method

.method public onCaptchaRequired(Ljava/lang/String;Ljava/lang/String;Lco/vine/android/service/PendingAction;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "captchaUrl"    # Ljava/lang/String;
    .param p3, "actionToRetry"    # Lco/vine/android/service/PendingAction;

    .prologue
    .line 312
    return-void
.end method

.method public onCheckTwitterComplete(Ljava/lang/String;ILjava/lang/String;IZLco/vine/android/api/VineUser;Lco/vine/android/api/VineLogin;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "errorCode"    # I
    .param p5, "accountExists"    # Z
    .param p6, "user"    # Lco/vine/android/api/VineUser;
    .param p7, "login"    # Lco/vine/android/api/VineLogin;

    .prologue
    .line 86
    return-void
.end method

.method public onClearCacheComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 229
    return-void
.end method

.method public onConnectFacebookComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 232
    return-void
.end method

.method public onConnectTwitterComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "username"    # Ljava/lang/String;
    .param p5, "token"    # Ljava/lang/String;
    .param p6, "secret"    # Ljava/lang/String;
    .param p7, "userId"    # J

    .prologue
    .line 188
    return-void
.end method

.method public onDeactivateAccountComplete(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "success"    # Z

    .prologue
    .line 299
    return-void
.end method

.method public onDeleteCommentComplete(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "commentId"    # J

    .prologue
    .line 369
    return-void
.end method

.method public onDeleteConversationComplete(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "aLong"    # J

    .prologue
    .line 354
    return-void
.end method

.method public onDeletePostComplete(Ljava/lang/String;JILjava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "postId"    # J
    .param p4, "statusCode"    # I
    .param p5, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 183
    return-void
.end method

.method public onDisableUserRepostsComplete(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "success"    # Z

    .prologue
    .line 295
    return-void
.end method

.method public onDisconnectTwitterComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 191
    return-void
.end method

.method public onEnableUserRepostsComplete(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "success"    # Z

    .prologue
    .line 291
    return-void
.end method

.method public onFacebookSessionChanged(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    .locals 0
    .param p1, "session"    # Lcom/facebook/Session;
    .param p2, "state"    # Lcom/facebook/SessionState;
    .param p3, "exception"    # Ljava/lang/Exception;

    .prologue
    .line 218
    return-void
.end method

.method public onFetchClientFlagsComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/VineClientFlags;Z)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "clientFlags"    # Lco/vine/android/api/VineClientFlags;
        .annotation build Lorg/jetbrains/annotations/Nullable;
        .end annotation
    .end param
    .param p5, "showBanner"    # Z

    .prologue
    .line 400
    return-void
.end method

.method public onFollowComplete(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "userId"    # J

    .prologue
    .line 145
    return-void
.end method

.method public onGcmRegistrationComplete(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "userId"    # J

    .prologue
    .line 271
    return-void
.end method

.method public onGetActivityComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/VinePagedData;Lco/vine/android/api/VinePagedData;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "Lco/vine/android/api/VinePagedData",
            "<",
            "Lco/vine/android/api/VineEverydayNotification;",
            ">;",
            "Lco/vine/android/api/VinePagedData",
            "<",
            "Lco/vine/android/api/VineSingleNotification;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 156
    .local p4, "notifications":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineEverydayNotification;>;"
    .local p5, "followRequests":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineSingleNotification;>;"
    return-void
.end method

.method public onGetActivityCountComplete(Ljava/lang/String;ILjava/lang/String;II)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "count"    # I
    .param p5, "followRequestCount"    # I

    .prologue
    .line 161
    return-void
.end method

.method public onGetAddressFriendsComplete(Ljava/lang/String;ILjava/lang/String;ILjava/util/ArrayList;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "count"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 165
    .local p5, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    return-void
.end method

.method public onGetBlockedUsersComplete(Ljava/lang/String;ILjava/lang/String;Ljava/util/ArrayList;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 249
    .local p4, "blockedUsers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    return-void
.end method

.method public onGetChannelsComplete(Ljava/lang/String;ILjava/lang/String;Ljava/util/ArrayList;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineChannel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 265
    .local p4, "channels":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineChannel;>;"
    return-void
.end method

.method public onGetCommentsComplete(Ljava/lang/String;ILjava/lang/String;IJLjava/util/ArrayList;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "nextPage"    # I
    .param p5, "anchor"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "IJ",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineComment;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 128
    .local p7, "comments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineComment;>;"
    return-void
.end method

.method public onGetConversationComplete(Ljava/lang/String;ILjava/lang/String;JIZ)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "conversationObjectId"    # J
    .param p6, "responseCode"    # I
    .param p7, "empty"    # Z

    .prologue
    .line 325
    return-void
.end method

.method public onGetConversationRemoteIdComplete(J)V
    .locals 0
    .param p1, "conversationId"    # J

    .prologue
    .line 331
    return-void
.end method

.method public onGetConversationRowIdComplete(JJLjava/lang/String;Z)V
    .locals 0
    .param p1, "recipientId"    # J
    .param p3, "conversationObjectId"    # J
    .param p5, "username"    # Ljava/lang/String;
    .param p6, "amFollowing"    # Z

    .prologue
    .line 328
    return-void
.end method

.method public onGetEditionsComplete(ILjava/util/ArrayList;)V
    .locals 0
    .param p1, "statusCode"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
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
    .line 82
    .local p2, "editions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;>;"
    return-void
.end method

.method public onGetFriendsTypeAheadComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "query"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 283
    .local p5, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    return-void
.end method

.method public onGetMessageCountComplete(Ljava/lang/String;ILjava/lang/String;I)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "messagesCount"    # I

    .prologue
    .line 381
    return-void
.end method

.method public onGetMessageInboxComplete(Ljava/lang/String;ILjava/lang/String;I)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "count"    # I

    .prologue
    .line 309
    return-void
.end method

.method public onGetNotificationSettingsComplete(Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineNotificationSetting;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 409
    .local p2, "notifSettings":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineNotificationSetting;>;"
    return-void
.end method

.method public onGetPendingNotificationCountComplete(Ljava/lang/String;ILjava/lang/String;I)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "count"    # I

    .prologue
    .line 275
    return-void
.end method

.method public onGetPostIdComplete(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "postId"    # J

    .prologue
    .line 214
    return-void
.end method

.method public onGetSinglePostComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/VinePost;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "post"    # Lco/vine/android/api/VinePost;

    .prologue
    .line 211
    return-void
.end method

.method public onGetTagTypeAheadComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "query"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineTag;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 287
    .local p5, "tags":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineTag;>;"
    return-void
.end method

.method public onGetTimeLineComplete(Ljava/lang/String;ILjava/lang/String;IIZLjava/util/ArrayList;Ljava/lang/String;IIIJZILjava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "type"    # I
    .param p5, "count"    # I
    .param p6, "memory"    # Z
    .param p8, "tag"    # Ljava/lang/String;
    .param p9, "pageType"    # I
    .param p10, "next"    # I
    .param p11, "previous"    # I
    .param p12, "anchor"    # J
    .param p14, "userInitiated"    # Z
    .param p15, "size"    # I
    .param p16, "title"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "IIZ",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VinePost;",
            ">;",
            "Ljava/lang/String;",
            "IIIJZI",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 142
    .local p7, "posts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    return-void
.end method

.method public onGetTwitterAuthUrlComplete(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "authUrl"    # Ljava/lang/String;

    .prologue
    .line 79
    return-void
.end method

.method public onGetTwitterFriendsComplete(Ljava/lang/String;ILjava/lang/String;ILjava/util/ArrayList;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "count"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 112
    .local p5, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    return-void
.end method

.method public onGetTwitterUserComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/TwitterUser;Lco/vine/android/api/VineLogin;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "user"    # Lco/vine/android/api/TwitterUser;
    .param p5, "login"    # Lco/vine/android/api/VineLogin;

    .prologue
    .line 90
    return-void
.end method

.method public onGetUserComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/VineUser;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "user"    # Lco/vine/android/api/VineUser;

    .prologue
    .line 171
    return-void
.end method

.method public onGetUserIdComplete(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "userId"    # J

    .prologue
    .line 315
    return-void
.end method

.method public onGetUserTypeAheadComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "query"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 279
    .local p5, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    return-void
.end method

.method public onGetUsersComplete(Lco/vine/android/client/Session;Ljava/lang/String;ILjava/lang/String;ILjava/util/ArrayList;IIJ)V
    .locals 0
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "reqId"    # Ljava/lang/String;
    .param p3, "statusCode"    # I
    .param p4, "reasonPhrase"    # Ljava/lang/String;
    .param p5, "count"    # I
    .param p7, "nextPage"    # I
    .param p8, "previousPage"    # I
    .param p9, "anchor"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lco/vine/android/client/Session;",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;IIJ)V"
        }
    .end annotation

    .prologue
    .line 75
    .local p6, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    return-void
.end method

.method public onGetUsersMeComplete(Ljava/lang/String;ILjava/lang/String;JLco/vine/android/api/VineUser;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "sessionOwnerId"    # J
    .param p6, "meUser"    # Lco/vine/android/api/VineUser;
        .annotation build Lorg/jetbrains/annotations/Nullable;
        .end annotation
    .end param

    .prologue
    .line 136
    return-void
.end method

.method public onIgnoreConversationComplete(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "conversationObjectId"    # J

    .prologue
    .line 351
    return-void
.end method

.method public onLikePost(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "postId"    # J

    .prologue
    .line 195
    return-void
.end method

.method public onLoginComplete(Lco/vine/android/client/Session;Ljava/lang/String;ILjava/lang/String;ILco/vine/android/api/VineLogin;)V
    .locals 0
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "reqId"    # Ljava/lang/String;
    .param p3, "statusCode"    # I
    .param p4, "reasonPhrase"    # Ljava/lang/String;
    .param p5, "errorCode"    # I
    .param p6, "login"    # Lco/vine/android/api/VineLogin;

    .prologue
    .line 48
    return-void
.end method

.method public onLogoutComplete(Ljava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;

    .prologue
    .line 56
    return-void
.end method

.method public onLowMemory()V
    .locals 0

    .prologue
    .line 302
    return-void
.end method

.method public onMergeNotificationComplete(Lco/vine/android/api/VineSingleNotification;Ljava/util/ArrayList;)V
    .locals 0
    .param p1, "lastNotification"    # Lco/vine/android/api/VineSingleNotification;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lco/vine/android/api/VineSingleNotification;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineSingleNotification;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 357
    .local p2, "notifications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    return-void
.end method

.method public onMobileDataNetworkActivated()V
    .locals 0

    .prologue
    .line 406
    return-void
.end method

.method public onPhotoImageError(Lco/vine/android/util/image/ImageKey;Lco/vine/android/network/HttpResult;)V
    .locals 0
    .param p1, "key"    # Lco/vine/android/util/image/ImageKey;
    .param p2, "result"    # Lco/vine/android/network/HttpResult;

    .prologue
    .line 102
    return-void
.end method

.method public onPhotoImageLoaded(Ljava/util/HashMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/image/ImageKey;",
            "Lco/vine/android/util/image/UrlImage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 98
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    return-void
.end method

.method public onPostCommentComplete(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Lco/vine/android/api/VineComment;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "postId"    # J
    .param p6, "comment"    # Ljava/lang/String;
    .param p7, "vc"    # Lco/vine/android/api/VineComment;

    .prologue
    .line 132
    return-void
.end method

.method public onPostVideoComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 392
    return-void
.end method

.method public onProfilePhotoUpdatedComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "avatarUrl"    # Ljava/lang/String;

    .prologue
    .line 320
    return-void
.end method

.method public onReceiveRTCMessage(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRTCConversation;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 379
    .local p1, "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRTCConversation;>;"
    return-void
.end method

.method public onRemoveUsersComplete(Ljava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;

    .prologue
    .line 168
    return-void
.end method

.method public onReportPostComplete(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "postId"    # J

    .prologue
    .line 180
    return-void
.end method

.method public onReportUserComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 245
    return-void
.end method

.method public onRequestEmailVerificationComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "email"    # Ljava/lang/String;

    .prologue
    .line 347
    return-void
.end method

.method public onRequestPhoneVerificationComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "phone"    # Ljava/lang/String;

    .prologue
    .line 335
    return-void
.end method

.method public onResetPasswordComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 116
    return-void
.end method

.method public onRespondFollowRequestComplete(Ljava/lang/String;ILjava/lang/String;ZJ)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "accept"    # Z
    .param p5, "userId"    # J

    .prologue
    .line 253
    return-void
.end method

.method public onRevine(Ljava/lang/String;ILjava/lang/String;JLco/vine/android/api/VineRepost;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "postId"    # J
    .param p6, "repost"    # Lco/vine/android/api/VineRepost;

    .prologue
    .line 203
    return-void
.end method

.method public onSaveNotificationSettingsComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 413
    return-void
.end method

.method public onSharePostComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 268
    return-void
.end method

.method public onSignUpComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/VineLogin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "vineLogin"    # Lco/vine/android/api/VineLogin;
    .param p5, "accountName"    # Ljava/lang/String;
    .param p6, "password"    # Ljava/lang/String;
    .param p7, "avatarUrl"    # Ljava/lang/String;

    .prologue
    .line 69
    return-void
.end method

.method public onSubscribeConversationComplete()V
    .locals 0

    .prologue
    .line 375
    return-void
.end method

.method public onTagSearchComplete(Ljava/lang/String;ILjava/lang/String;III)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "count"    # I
    .param p5, "nextPage"    # I
    .param p6, "previousPage"    # I

    .prologue
    .line 226
    return-void
.end method

.method public onTrimMemory(I)V
    .locals 0
    .param p1, "level"    # I

    .prologue
    .line 305
    return-void
.end method

.method public onTwitterxAuthComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/VineLogin;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "login"    # Lco/vine/android/api/VineLogin;

    .prologue
    .line 107
    return-void
.end method

.method public onUnFollowComplete(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "userId"    # J

    .prologue
    .line 151
    return-void
.end method

.method public onUnblockUserComplete(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "userUnblocked"    # Z

    .prologue
    .line 242
    return-void
.end method

.method public onUnlikePost(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "postId"    # J

    .prologue
    .line 199
    return-void
.end method

.method public onUnrevine(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "postId"    # J

    .prologue
    .line 207
    return-void
.end method

.method public onUpdateAcceptOonComplete(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "acceptOon"    # Z

    .prologue
    .line 385
    return-void
.end method

.method public onUpdateDiscoverability(Ljava/lang/String;ILjava/lang/String;IZ)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "type"    # I
    .param p5, "enable"    # Z

    .prologue
    .line 396
    return-void
.end method

.method public onUpdateEditionComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "edition"    # Ljava/lang/String;

    .prologue
    .line 177
    return-void
.end method

.method public onUpdateEnableAddressBookComplete(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "enableAddressBook"    # Z

    .prologue
    .line 389
    return-void
.end method

.method public onUpdateExplicitComplete(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "explicit"    # Z

    .prologue
    .line 257
    return-void
.end method

.method public onUpdateFollowEditorsPicksComplete(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "isFollowing"    # Z

    .prologue
    .line 236
    return-void
.end method

.method public onUpdatePrivateComplete(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "priv"    # Z

    .prologue
    .line 261
    return-void
.end method

.method public onUpdateProfileComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "avatarUri"    # Ljava/lang/String;

    .prologue
    .line 174
    return-void
.end method

.method public onUpdateTypingStateComplete(Z)V
    .locals 0
    .param p1, "isTyping"    # Z

    .prologue
    .line 372
    return-void
.end method

.method public onUserSearchComplete(Ljava/lang/String;ILjava/lang/String;III)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "count"    # I
    .param p5, "nextPage"    # I
    .param p6, "previousPage"    # I

    .prologue
    .line 222
    return-void
.end method

.method public onVerifyEmailComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 343
    return-void
.end method

.method public onVerifyPhoneNumberComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 339
    return-void
.end method

.method public onVideoPathError(Lco/vine/android/util/video/VideoKey;Lco/vine/android/network/HttpResult;)V
    .locals 0
    .param p1, "key"    # Lco/vine/android/util/video/VideoKey;
    .param p2, "result"    # Lco/vine/android/network/HttpResult;

    .prologue
    .line 124
    return-void
.end method

.method public onVideoPathObtained(Ljava/util/HashMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/video/VideoKey;",
            "Lco/vine/android/util/video/UrlVideo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 120
    .local p1, "videos":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/video/VideoKey;Lco/vine/android/util/video/UrlVideo;>;"
    return-void
.end method

.method public onWebSocketConnectComplete()V
    .locals 0

    .prologue
    .line 360
    return-void
.end method

.method public onWebSocketDisconnected()V
    .locals 0

    .prologue
    .line 363
    return-void
.end method

.method public onWebSocketError()V
    .locals 0

    .prologue
    .line 366
    return-void
.end method
