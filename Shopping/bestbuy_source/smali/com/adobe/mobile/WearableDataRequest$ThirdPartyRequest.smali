.class Lcom/adobe/mobile/WearableDataRequest$ThirdPartyRequest;
.super Lcom/adobe/mobile/WearableDataRequest$Post;
.source "SourceFile"


# static fields
.field protected static final logPrefix:Ljava/lang/String; = "Wearable Third Party Request Forward"


# instance fields
.field protected postType:Ljava/lang/String;


# direct methods
.method protected constructor <init>(Latz;)V
    .locals 1

    .prologue
    .line 205
    invoke-direct {p0, p1}, Lcom/adobe/mobile/WearableDataRequest$Post;-><init>(Latz;)V

    .line 206
    const-string v0, "PostType"

    invoke-virtual {p1, v0}, Latz;->f(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$ThirdPartyRequest;->postType:Ljava/lang/String;

    .line 207
    return-void
.end method

.method protected constructor <init>(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 196
    invoke-direct {p0, p1, p2, p3}, Lcom/adobe/mobile/WearableDataRequest$Post;-><init>(Ljava/lang/String;Ljava/lang/String;I)V

    .line 197
    return-void
.end method

.method protected constructor <init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 200
    invoke-direct {p0, p1, p2, p3}, Lcom/adobe/mobile/WearableDataRequest$ThirdPartyRequest;-><init>(Ljava/lang/String;Ljava/lang/String;I)V

    .line 201
    iput-object p4, p0, Lcom/adobe/mobile/WearableDataRequest$ThirdPartyRequest;->postType:Ljava/lang/String;

    .line 202
    return-void
.end method


# virtual methods
.method protected getDataMap()Latz;
    .locals 3

    .prologue
    .line 211
    invoke-super {p0}, Lcom/adobe/mobile/WearableDataRequest$Post;->getDataMap()Latz;

    move-result-object v0

    .line 212
    const-string v1, "Type"

    const-string v2, "ThirdParty"

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 213
    const-string v1, "PostType"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$ThirdPartyRequest;->postType:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 214
    return-object v0
.end method

.method protected handle(Landroid/content/Context;)Latz;
    .locals 7

    .prologue
    .line 219
    new-instance v6, Latz;

    invoke-direct {v6}, Latz;-><init>()V

    .line 222
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 223
    const-string v0, "Accept-Language"

    invoke-static {p1}, Lcom/adobe/mobile/WearableDataRequest$ThirdPartyRequest;->getDefaultAcceptLanguage(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 224
    const-string v0, "User-Agent"

    invoke-static {p1}, Lcom/adobe/mobile/WearableDataRequest$ThirdPartyRequest;->getDefaultUserAgent(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 226
    iget-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$ThirdPartyRequest;->url:Ljava/lang/String;

    iget-object v1, p0, Lcom/adobe/mobile/WearableDataRequest$ThirdPartyRequest;->body:Ljava/lang/String;

    iget v3, p0, Lcom/adobe/mobile/WearableDataRequest$ThirdPartyRequest;->timeOut:I

    iget-object v4, p0, Lcom/adobe/mobile/WearableDataRequest$ThirdPartyRequest;->postType:Ljava/lang/String;

    const-string v5, "Wearable Third Party Request Forward"

    invoke-static/range {v0 .. v5}, Lcom/adobe/mobile/RequestHandler;->sendThirdPartyRequest(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;Ljava/lang/String;)Z

    move-result v0

    .line 228
    const-string v1, "Result"

    invoke-virtual {v6, v1, v0}, Latz;->a(Ljava/lang/String;Z)V

    .line 229
    const-string v0, "ID"

    iget-object v1, p0, Lcom/adobe/mobile/WearableDataRequest$ThirdPartyRequest;->uuid:Ljava/lang/String;

    invoke-virtual {v6, v0, v1}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 230
    const-string v0, "Type"

    const-string v1, "ThirdParty"

    invoke-virtual {v6, v0, v1}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 231
    return-object v6
.end method
