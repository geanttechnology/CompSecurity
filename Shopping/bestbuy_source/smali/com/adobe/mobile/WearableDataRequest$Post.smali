.class Lcom/adobe/mobile/WearableDataRequest$Post;
.super Lcom/adobe/mobile/WearableDataRequest;
.source "SourceFile"


# static fields
.field private static final _userAgentMutex:Ljava/lang/Object;

.field protected static final logPrefix:Ljava/lang/String; = "Wearable POST Request Forward"

.field private static userAgent:Ljava/lang/String;


# instance fields
.field protected body:Ljava/lang/String;

.field protected url:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 173
    const/4 v0, 0x0

    sput-object v0, Lcom/adobe/mobile/WearableDataRequest$Post;->userAgent:Ljava/lang/String;

    .line 174
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/adobe/mobile/WearableDataRequest$Post;->_userAgentMutex:Ljava/lang/Object;

    return-void
.end method

.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 110
    invoke-direct {p0}, Lcom/adobe/mobile/WearableDataRequest;-><init>()V

    return-void
.end method

.method protected constructor <init>(Latz;)V
    .locals 1

    .prologue
    .line 118
    invoke-direct {p0}, Lcom/adobe/mobile/WearableDataRequest;-><init>()V

    .line 119
    const-string v0, "Timeout"

    invoke-virtual {p1, v0}, Latz;->d(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->timeOut:I

    .line 120
    const-string v0, "URL"

    invoke-virtual {p1, v0}, Latz;->f(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->url:Ljava/lang/String;

    .line 121
    const-string v0, "Body"

    invoke-virtual {p1, v0}, Latz;->f(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->body:Ljava/lang/String;

    .line 122
    const-string v0, "ID"

    invoke-virtual {p1, v0}, Latz;->f(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->uuid:Ljava/lang/String;

    .line 123
    return-void
.end method

.method protected constructor <init>(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 113
    invoke-direct {p0, p3}, Lcom/adobe/mobile/WearableDataRequest;-><init>(I)V

    .line 114
    iput-object p1, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->url:Ljava/lang/String;

    .line 115
    iput-object p2, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->body:Ljava/lang/String;

    .line 116
    return-void
.end method

.method protected static getDefaultAcceptLanguage(Landroid/content/Context;)Ljava/lang/String;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 153
    if-nez p0, :cond_1

    .line 170
    :cond_0
    :goto_0
    return-object v0

    .line 155
    :cond_1
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 156
    if-eqz v1, :cond_0

    .line 160
    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    .line 161
    if-eqz v1, :cond_0

    .line 165
    iget-object v1, v1, Landroid/content/res/Configuration;->locale:Ljava/util/Locale;

    .line 166
    if-eqz v1, :cond_0

    .line 170
    invoke-virtual {v1}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v0

    const/16 v1, 0x5f

    const/16 v2, 0x2d

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected static getDefaultUserAgent(Landroid/content/Context;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 176
    sget-object v1, Lcom/adobe/mobile/WearableDataRequest$Post;->_userAgentMutex:Ljava/lang/Object;

    monitor-enter v1

    .line 177
    :try_start_0
    sget-object v0, Lcom/adobe/mobile/WearableDataRequest$Post;->userAgent:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 178
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Mozilla/5.0 (Linux; U; Android "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "; "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 179
    invoke-static {p0}, Lcom/adobe/mobile/WearableDataRequest$Post;->getDefaultAcceptLanguage(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "; "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " Build/"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Landroid/os/Build;->ID:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ")"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mobile/WearableDataRequest$Post;->userAgent:Ljava/lang/String;

    .line 182
    :cond_0
    sget-object v0, Lcom/adobe/mobile/WearableDataRequest$Post;->userAgent:Ljava/lang/String;

    monitor-exit v1

    return-object v0

    .line 183
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method


# virtual methods
.method protected getDataMap()Latz;
    .locals 3

    .prologue
    .line 126
    new-instance v0, Latz;

    invoke-direct {v0}, Latz;-><init>()V

    .line 127
    const-string v1, "ID"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->uuid:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 128
    const-string v1, "Type"

    const-string v2, "POST"

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    const-string v1, "URL"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->url:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    const-string v1, "Timeout"

    iget v2, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->timeOut:I

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;I)V

    .line 131
    const-string v1, "Body"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->body:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 132
    return-object v0
.end method

.method protected getURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 187
    iget-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->url:Ljava/lang/String;

    return-object v0
.end method

.method protected handle(Landroid/content/Context;)Latz;
    .locals 6

    .prologue
    .line 136
    new-instance v0, Latz;

    invoke-direct {v0}, Latz;-><init>()V

    .line 139
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 141
    const-string v2, "Accept-Language"

    invoke-static {p1}, Lcom/adobe/mobile/WearableDataRequest$Post;->getDefaultAcceptLanguage(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    const-string v2, "User-Agent"

    invoke-static {p1}, Lcom/adobe/mobile/WearableDataRequest$Post;->getDefaultUserAgent(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 144
    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->url:Ljava/lang/String;

    iget-object v3, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->body:Ljava/lang/String;

    iget v4, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->timeOut:I

    const-string v5, "Wearable POST Request Forward"

    invoke-static {v2, v3, v1, v4, v5}, Lcom/adobe/mobile/RequestHandler;->sendAnalyticsRequest(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;)Z

    move-result v1

    .line 146
    const-string v2, "Result"

    invoke-virtual {v0, v2, v1}, Latz;->a(Ljava/lang/String;Z)V

    .line 147
    const-string v1, "ID"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->uuid:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 148
    const-string v1, "Type"

    const-string v2, "POST"

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 149
    return-object v0
.end method
