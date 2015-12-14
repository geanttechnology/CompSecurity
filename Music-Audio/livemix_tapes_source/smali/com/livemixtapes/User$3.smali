.class Lcom/livemixtapes/User$3;
.super Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;
.source "User.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/User;->login(Ljava/lang/String;Ljava/lang/String;Lcom/livemixtapes/User$UserCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private final synthetic val$callback:Lcom/livemixtapes/User$UserCallback;


# direct methods
.method constructor <init>(Lcom/livemixtapes/User$UserCallback;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/User$3;->val$callback:Lcom/livemixtapes/User$UserCallback;

    .line 224
    invoke-direct {p0}, Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;-><init>()V

    return-void
.end method


# virtual methods
.method protected always()V
    .locals 1

    .prologue
    .line 261
    iget-object v0, p0, Lcom/livemixtapes/User$3;->val$callback:Lcom/livemixtapes/User$UserCallback;

    invoke-virtual {v0}, Lcom/livemixtapes/User$UserCallback;->always()V

    .line 262
    return-void
.end method

.method protected exception(Ljava/lang/Exception;)V
    .locals 3
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 257
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    .line 254
    const-string v2, "EXCEPTION"

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 255
    invoke-virtual {p1}, Ljava/lang/Exception;->printStackTrace()V

    .line 256
    iget-object v0, p0, Lcom/livemixtapes/User$3;->val$callback:Lcom/livemixtapes/User$UserCallback;

    const/4 v1, 0x4

    invoke-virtual {v0, v1, p1}, Lcom/livemixtapes/User$UserCallback;->failure(ILjava/lang/Exception;)V

    return-void
.end method

.method protected success(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 6
    .param p1, "data"    # Ljava/lang/String;
    .param p2, "reasonPhrase"    # Ljava/lang/String;
    .param p3, "statusCode"    # I

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 227
    # invokes: Lcom/livemixtapes/User;->getJsonMap(Ljava/lang/String;)Ljava/util/Map;
    invoke-static {p1}, Lcom/livemixtapes/User;->access$0(Ljava/lang/String;)Ljava/util/Map;

    move-result-object v1

    .line 229
    .local v1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    if-nez v1, :cond_0

    new-array v2, v3, [Ljava/lang/Object;

    .line 230
    const-string v3, "INVALID JSON"

    aput-object v3, v2, v4

    invoke-static {v2}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 231
    iget-object v2, p0, Lcom/livemixtapes/User$3;->val$callback:Lcom/livemixtapes/User$UserCallback;

    const/4 v3, 0x2

    invoke-virtual {v2, v3, v5}, Lcom/livemixtapes/User$UserCallback;->failure(ILjava/lang/Exception;)V

    .line 250
    :goto_0
    return-void

    .line 235
    :cond_0
    const-string v2, "auth_token"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 237
    :try_start_0
    const-string v2, "auth_token"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    # invokes: Lcom/livemixtapes/User;->setAuth(Ljava/lang/String;)V
    invoke-static {v2}, Lcom/livemixtapes/User;->access$3(Ljava/lang/String;)V

    .line 238
    # invokes: Lcom/livemixtapes/User;->setUserData(Ljava/util/Map;)V
    invoke-static {v1}, Lcom/livemixtapes/User;->access$1(Ljava/util/Map;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 246
    iget-object v2, p0, Lcom/livemixtapes/User$3;->val$callback:Lcom/livemixtapes/User$UserCallback;

    # getter for: Lcom/livemixtapes/User;->userData:Lcom/livemixtapes/User$UserData;
    invoke-static {}, Lcom/livemixtapes/User;->access$2()Lcom/livemixtapes/User$UserData;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/livemixtapes/User$UserCallback;->success(Lcom/livemixtapes/User$UserData;)V

    goto :goto_0

    .line 239
    :catch_0
    move-exception v0

    .local v0, "e":Ljava/lang/Exception;
    new-array v2, v3, [Ljava/lang/Object;

    .line 240
    const-string v3, "NO AUTH TOKEN"

    aput-object v3, v2, v4

    invoke-static {v2}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 241
    invoke-static {}, Lcom/livemixtapes/User;->logout()V

    .line 242
    iget-object v2, p0, Lcom/livemixtapes/User$3;->val$callback:Lcom/livemixtapes/User$UserCallback;

    const/4 v3, 0x4

    invoke-virtual {v2, v3, v0}, Lcom/livemixtapes/User$UserCallback;->failure(ILjava/lang/Exception;)V

    goto :goto_0

    .line 248
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    iget-object v2, p0, Lcom/livemixtapes/User$3;->val$callback:Lcom/livemixtapes/User$UserCallback;

    invoke-virtual {v2, v3, v5}, Lcom/livemixtapes/User$UserCallback;->failure(ILjava/lang/Exception;)V

    goto :goto_0
.end method
