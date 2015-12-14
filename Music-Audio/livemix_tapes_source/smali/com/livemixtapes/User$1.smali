.class Lcom/livemixtapes/User$1;
.super Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;
.source "User.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/User;->refresh(Lcom/livemixtapes/User$UserCallback;)V
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
    iput-object p1, p0, Lcom/livemixtapes/User$1;->val$callback:Lcom/livemixtapes/User$UserCallback;

    .line 123
    invoke-direct {p0}, Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;-><init>()V

    return-void
.end method


# virtual methods
.method protected always()V
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/livemixtapes/User$1;->val$callback:Lcom/livemixtapes/User$UserCallback;

    invoke-virtual {v0}, Lcom/livemixtapes/User$UserCallback;->always()V

    .line 158
    return-void
.end method

.method protected exception(Ljava/lang/Exception;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 152
    iget-object v0, p0, Lcom/livemixtapes/User$1;->val$callback:Lcom/livemixtapes/User$UserCallback;

    const/4 v1, 0x4

    invoke-virtual {v0, v1, p1}, Lcom/livemixtapes/User$UserCallback;->failure(ILjava/lang/Exception;)V

    .line 153
    return-void
.end method

.method protected success(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 6
    .param p1, "data"    # Ljava/lang/String;
    .param p2, "reasonPhrase"    # Ljava/lang/String;
    .param p3, "statusCode"    # I

    .prologue
    const/4 v5, 0x0

    .line 126
    # invokes: Lcom/livemixtapes/User;->getJsonMap(Ljava/lang/String;)Ljava/util/Map;
    invoke-static {p1}, Lcom/livemixtapes/User;->access$0(Ljava/lang/String;)Ljava/util/Map;

    move-result-object v2

    .line 128
    .local v2, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    if-nez v2, :cond_0

    .line 129
    iget-object v3, p0, Lcom/livemixtapes/User$1;->val$callback:Lcom/livemixtapes/User$UserCallback;

    const/4 v4, 0x2

    invoke-virtual {v3, v4, v5}, Lcom/livemixtapes/User$UserCallback;->failure(ILjava/lang/Exception;)V

    .line 148
    :goto_0
    return-void

    .line 133
    :cond_0
    const-string v3, "user"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 135
    :try_start_0
    const-string v3, "user"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    move-object v0, v3

    check-cast v0, Ljava/util/Map;

    move-object v2, v0

    .line 136
    # invokes: Lcom/livemixtapes/User;->setUserData(Ljava/util/Map;)V
    invoke-static {v2}, Lcom/livemixtapes/User;->access$1(Ljava/util/Map;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 143
    iget-object v3, p0, Lcom/livemixtapes/User$1;->val$callback:Lcom/livemixtapes/User$UserCallback;

    # getter for: Lcom/livemixtapes/User;->userData:Lcom/livemixtapes/User$UserData;
    invoke-static {}, Lcom/livemixtapes/User;->access$2()Lcom/livemixtapes/User$UserData;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/livemixtapes/User$UserCallback;->success(Lcom/livemixtapes/User$UserData;)V

    goto :goto_0

    .line 137
    :catch_0
    move-exception v1

    .line 138
    .local v1, "e":Ljava/lang/Exception;
    invoke-static {}, Lcom/livemixtapes/User;->logout()V

    .line 139
    iget-object v3, p0, Lcom/livemixtapes/User$1;->val$callback:Lcom/livemixtapes/User$UserCallback;

    const/4 v4, 0x4

    invoke-virtual {v3, v4, v1}, Lcom/livemixtapes/User$UserCallback;->failure(ILjava/lang/Exception;)V

    goto :goto_0

    .line 145
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_1
    invoke-static {}, Lcom/livemixtapes/User;->logout()V

    .line 146
    iget-object v3, p0, Lcom/livemixtapes/User$1;->val$callback:Lcom/livemixtapes/User$UserCallback;

    const/4 v4, 0x0

    invoke-virtual {v3, v4, v5}, Lcom/livemixtapes/User$UserCallback;->failure(ILjava/lang/Exception;)V

    goto :goto_0
.end method
