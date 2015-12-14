.class Lcom/livemixtapes/User$2;
.super Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;
.source "User.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/User;->signup(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/livemixtapes/User$SignupCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private final synthetic val$callback:Lcom/livemixtapes/User$SignupCallback;


# direct methods
.method constructor <init>(Lcom/livemixtapes/User$SignupCallback;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/User$2;->val$callback:Lcom/livemixtapes/User$SignupCallback;

    .line 186
    invoke-direct {p0}, Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;-><init>()V

    return-void
.end method


# virtual methods
.method protected always()V
    .locals 1

    .prologue
    .line 211
    iget-object v0, p0, Lcom/livemixtapes/User$2;->val$callback:Lcom/livemixtapes/User$SignupCallback;

    invoke-virtual {v0}, Lcom/livemixtapes/User$SignupCallback;->always()V

    .line 212
    return-void
.end method

.method protected exception(Ljava/lang/Exception;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 206
    iget-object v0, p0, Lcom/livemixtapes/User$2;->val$callback:Lcom/livemixtapes/User$SignupCallback;

    const/4 v1, 0x4

    invoke-virtual {v0, v1, p1}, Lcom/livemixtapes/User$SignupCallback;->failure(ILjava/lang/Exception;)V

    .line 207
    return-void
.end method

.method protected success(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 4
    .param p1, "data"    # Ljava/lang/String;
    .param p2, "reasonPhrase"    # Ljava/lang/String;
    .param p3, "statusCode"    # I

    .prologue
    .line 189
    # invokes: Lcom/livemixtapes/User;->getJsonMap(Ljava/lang/String;)Ljava/util/Map;
    invoke-static {p1}, Lcom/livemixtapes/User;->access$0(Ljava/lang/String;)Ljava/util/Map;

    move-result-object v0

    .line 191
    .local v0, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    if-nez v0, :cond_0

    .line 192
    iget-object v1, p0, Lcom/livemixtapes/User$2;->val$callback:Lcom/livemixtapes/User$SignupCallback;

    const/4 v2, 0x2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/livemixtapes/User$SignupCallback;->failure(ILjava/lang/Exception;)V

    .line 202
    :goto_0
    return-void

    .line 196
    :cond_0
    const-string v1, "status"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 198
    iget-object v1, p0, Lcom/livemixtapes/User$2;->val$callback:Lcom/livemixtapes/User$SignupCallback;

    invoke-virtual {v1}, Lcom/livemixtapes/User$SignupCallback;->success()V

    goto :goto_0

    .line 200
    :cond_1
    iget-object v1, p0, Lcom/livemixtapes/User$2;->val$callback:Lcom/livemixtapes/User$SignupCallback;

    invoke-virtual {v1, p1}, Lcom/livemixtapes/User$SignupCallback;->signup_failure(Ljava/lang/String;)V

    goto :goto_0
.end method
