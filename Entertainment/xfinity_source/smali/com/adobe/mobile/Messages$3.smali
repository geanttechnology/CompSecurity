.class final Lcom/adobe/mobile/Messages$3;
.super Ljava/lang/Object;
.source "Messages.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mobile/Messages;->checkForInAppMessage(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$cdata:Ljava/util/Map;

.field final synthetic val$lifecycleData:Ljava/util/Map;

.field final synthetic val$vars:Ljava/util/Map;


# direct methods
.method constructor <init>(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V
    .locals 0

    .prologue
    .line 130
    iput-object p1, p0, Lcom/adobe/mobile/Messages$3;->val$vars:Ljava/util/Map;

    iput-object p2, p0, Lcom/adobe/mobile/Messages$3;->val$cdata:Ljava/util/Map;

    iput-object p3, p0, Lcom/adobe/mobile/Messages$3;->val$lifecycleData:Ljava/util/Map;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 133
    const/4 v3, 0x0

    .line 135
    .local v3, "messages":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/adobe/mobile/Message;>;"
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v4

    if-nez v4, :cond_0

    .line 136
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mobile/MobileConfig;->getInAppMessages()Ljava/util/ArrayList;

    move-result-object v3

    .line 139
    :cond_0
    if-eqz v3, :cond_1

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-gtz v4, :cond_2

    .line 161
    :cond_1
    :goto_0
    return-void

    .line 144
    :cond_2
    iget-object v4, p0, Lcom/adobe/mobile/Messages$3;->val$vars:Ljava/util/Map;

    if-eqz v4, :cond_3

    iget-object v4, p0, Lcom/adobe/mobile/Messages$3;->val$vars:Ljava/util/Map;

    const-string v5, "pev2"

    invoke-interface {v4, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    iget-object v4, p0, Lcom/adobe/mobile/Messages$3;->val$vars:Ljava/util/Map;

    const-string v5, "pev2"

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    const-string v5, "ADBINTERNAL:In-App Message"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 150
    :cond_3
    iget-object v4, p0, Lcom/adobe/mobile/Messages$3;->val$cdata:Ljava/util/Map;

    invoke-static {v4}, Lcom/adobe/mobile/Messages;->lowercaseKeysForMap(Ljava/util/Map;)Ljava/util/HashMap;

    move-result-object v0

    .line 151
    .local v0, "lowercaseContextData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v4, p0, Lcom/adobe/mobile/Messages$3;->val$vars:Ljava/util/Map;

    invoke-static {v4}, Lcom/adobe/mobile/Messages;->lowercaseKeysForMap(Ljava/util/Map;)Ljava/util/HashMap;

    move-result-object v1

    .line 153
    .local v1, "lowercaseVars":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_4
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/adobe/mobile/Message;

    .line 154
    .local v2, "message":Lcom/adobe/mobile/Message;
    iget-object v5, p0, Lcom/adobe/mobile/Messages$3;->val$lifecycleData:Ljava/util/Map;

    invoke-virtual {v2, v1, v0, v5}, Lcom/adobe/mobile/Message;->shouldShowForVariables(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 155
    invoke-virtual {v2}, Lcom/adobe/mobile/Message;->show()V

    goto :goto_0
.end method
