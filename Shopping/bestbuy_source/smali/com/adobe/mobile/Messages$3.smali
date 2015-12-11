.class final Lcom/adobe/mobile/Messages$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mobile/Messages;->checkForInAppMessage(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V
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
    .locals 5

    .prologue
    .line 133
    const/4 v0, 0x0

    .line 135
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v1

    if-nez v1, :cond_0

    .line 136
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mobile/MobileConfig;->getInAppMessages()Ljava/util/ArrayList;

    move-result-object v0

    .line 139
    :cond_0
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-gtz v1, :cond_2

    .line 161
    :cond_1
    :goto_0
    return-void

    .line 144
    :cond_2
    iget-object v1, p0, Lcom/adobe/mobile/Messages$3;->val$vars:Ljava/util/Map;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/adobe/mobile/Messages$3;->val$vars:Ljava/util/Map;

    const-string v2, "pev2"

    invoke-interface {v1, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/adobe/mobile/Messages$3;->val$vars:Ljava/util/Map;

    const-string v2, "pev2"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "ADBINTERNAL:In-App Message"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 150
    :cond_3
    iget-object v1, p0, Lcom/adobe/mobile/Messages$3;->val$cdata:Ljava/util/Map;

    invoke-static {v1}, Lcom/adobe/mobile/Messages;->lowercaseKeysForMap(Ljava/util/Map;)Ljava/util/HashMap;

    move-result-object v1

    .line 151
    iget-object v2, p0, Lcom/adobe/mobile/Messages$3;->val$vars:Ljava/util/Map;

    invoke-static {v2}, Lcom/adobe/mobile/Messages;->lowercaseKeysForMap(Ljava/util/Map;)Ljava/util/HashMap;

    move-result-object v2

    .line 153
    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_4
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mobile/Message;

    .line 154
    iget-object v4, p0, Lcom/adobe/mobile/Messages$3;->val$lifecycleData:Ljava/util/Map;

    invoke-virtual {v0, v2, v1, v4}, Lcom/adobe/mobile/Message;->shouldShowForVariables(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 155
    invoke-virtual {v0}, Lcom/adobe/mobile/Message;->show()V

    goto :goto_0
.end method
