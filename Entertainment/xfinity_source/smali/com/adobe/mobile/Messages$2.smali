.class final Lcom/adobe/mobile/Messages$2;
.super Ljava/lang/Object;
.source "Messages.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mobile/Messages;->checkFor3rdPartyCallbacks(Ljava/util/Map;Ljava/util/Map;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$cdata:Ljava/util/Map;

.field final synthetic val$vars:Ljava/util/Map;


# direct methods
.method constructor <init>(Ljava/util/Map;Ljava/util/Map;)V
    .locals 0

    .prologue
    .line 101
    iput-object p1, p0, Lcom/adobe/mobile/Messages$2;->val$cdata:Ljava/util/Map;

    iput-object p2, p0, Lcom/adobe/mobile/Messages$2;->val$vars:Ljava/util/Map;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 104
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mobile/MobileConfig;->getCallbackTemplates()Ljava/util/ArrayList;

    move-result-object v0

    .line 107
    .local v0, "callbacks":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/adobe/mobile/Message;>;"
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-gtz v5, :cond_1

    .line 121
    :cond_0
    return-void

    .line 111
    :cond_1
    new-instance v1, Ljava/util/HashMap;

    invoke-static {}, Lcom/adobe/mobile/Lifecycle;->getContextDataLowercase()Ljava/util/Map;

    move-result-object v5

    invoke-direct {v1, v5}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    .line 112
    .local v1, "lifecycleData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v5, p0, Lcom/adobe/mobile/Messages$2;->val$cdata:Ljava/util/Map;

    invoke-static {v5}, Lcom/adobe/mobile/Messages;->lowercaseKeysForMap(Ljava/util/Map;)Ljava/util/HashMap;

    move-result-object v2

    .line 113
    .local v2, "lowercaseContextData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v5, p0, Lcom/adobe/mobile/Messages$2;->val$vars:Ljava/util/Map;

    invoke-static {v5}, Lcom/adobe/mobile/Messages;->lowercaseKeysForMap(Ljava/util/Map;)Ljava/util/HashMap;

    move-result-object v3

    .line 116
    .local v3, "lowercaseVars":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_2
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/adobe/mobile/Message;

    .line 117
    .local v4, "message":Lcom/adobe/mobile/Message;
    invoke-virtual {v4, v3, v2, v1}, Lcom/adobe/mobile/Message;->shouldShowForVariables(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 118
    invoke-virtual {v4}, Lcom/adobe/mobile/Message;->show()V

    goto :goto_0
.end method
