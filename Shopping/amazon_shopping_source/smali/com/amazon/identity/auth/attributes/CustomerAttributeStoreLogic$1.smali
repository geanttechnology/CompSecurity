.class Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;
.super Ljava/lang/Object;
.source "CustomerAttributeStoreLogic.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->getAttribute(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;Ljava/util/EnumSet;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;

.field final synthetic val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$key:Ljava/lang/String;

.field final synthetic val$options:Ljava/util/EnumSet;

.field final synthetic val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;Ljava/lang/String;Lcom/amazon/identity/auth/device/callback/CallbackFuture;Ljava/lang/String;Ljava/util/EnumSet;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 0

    .prologue
    .line 150
    iput-object p1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->this$0:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;

    iput-object p2, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$key:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    iput-object p4, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$directedId:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$options:Ljava/util/EnumSet;

    iput-object p6, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    .line 155
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$key:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->parseKey(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/KeyInfo;

    move-result-object v3

    .line 156
    .local v3, "keyInfo":Lcom/amazon/identity/auth/device/utils/KeyInfo;
    invoke-static {v3}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreKeyUtils;->isCorPfm(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 158
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->this$0:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$directedId:Ljava/lang/String;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$options:Ljava/util/EnumSet;

    invoke-static {v0, v1, v2, v4, v5}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->access$000(Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Ljava/lang/String;Ljava/util/EnumSet;)V

    .line 179
    :goto_0
    return-void

    .line 160
    :cond_0
    invoke-static {v3}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreKeyUtils;->isCustomerProfileAttributeKey(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 162
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->this$0:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$directedId:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$options:Ljava/util/EnumSet;

    iget-object v5, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->access$100(Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Ljava/util/EnumSet;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0

    .line 164
    :cond_1
    invoke-static {v3}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreKeyUtils;->isXMainAndXACBCookies(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 168
    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackagelessKeyInfo()Lcom/amazon/identity/auth/device/utils/KeyInfo;

    move-result-object v7

    .line 169
    .local v7, "canonicalXmainXacbCookieKey":Lcom/amazon/identity/auth/device/utils/KeyInfo;
    iget-object v4, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->this$0:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;

    iget-object v5, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    iget-object v6, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$directedId:Ljava/lang/String;

    iget-object v8, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$options:Ljava/util/EnumSet;

    iget-object v9, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-static/range {v4 .. v9}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->access$200(Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Ljava/util/EnumSet;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0

    .line 171
    .end local v7    # "canonicalXmainXacbCookieKey":Lcom/amazon/identity/auth/device/utils/KeyInfo;
    :cond_2
    invoke-static {v3}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreKeyUtils;->isXFSNCookie(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 173
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->this$0:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$directedId:Ljava/lang/String;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->access$300(Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;)V

    goto :goto_0

    .line 177
    :cond_3
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->this$0:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->access$400(Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V

    goto :goto_0
.end method
