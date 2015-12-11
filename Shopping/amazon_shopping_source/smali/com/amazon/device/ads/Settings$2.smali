.class Lcom/amazon/device/ads/Settings$2;
.super Ljava/lang/Object;
.source "Settings.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/Settings;->writeCacheToSharedPreferences(Landroid/content/SharedPreferences;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/Settings;

.field final synthetic val$sharedPreferences:Landroid/content/SharedPreferences;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/Settings;Landroid/content/SharedPreferences;)V
    .locals 0

    .prologue
    .line 224
    iput-object p1, p0, Lcom/amazon/device/ads/Settings$2;->this$0:Lcom/amazon/device/ads/Settings;

    iput-object p2, p0, Lcom/amazon/device/ads/Settings$2;->val$sharedPreferences:Landroid/content/SharedPreferences;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 229
    iget-object v4, p0, Lcom/amazon/device/ads/Settings$2;->this$0:Lcom/amazon/device/ads/Settings;

    # getter for: Lcom/amazon/device/ads/Settings;->writeToSharedPreferencesLock:Ljava/util/concurrent/locks/ReentrantLock;
    invoke-static {v4}, Lcom/amazon/device/ads/Settings;->access$000(Lcom/amazon/device/ads/Settings;)Ljava/util/concurrent/locks/ReentrantLock;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 230
    iget-object v4, p0, Lcom/amazon/device/ads/Settings$2;->val$sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v4}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 233
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    .line 234
    iget-object v4, p0, Lcom/amazon/device/ads/Settings$2;->this$0:Lcom/amazon/device/ads/Settings;

    # getter for: Lcom/amazon/device/ads/Settings;->cache:Ljava/util/concurrent/ConcurrentHashMap;
    invoke-static {v4}, Lcom/amazon/device/ads/Settings;->access$100(Lcom/amazon/device/ads/Settings;)Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/concurrent/ConcurrentHashMap;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 236
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/device/ads/Settings$Value;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/device/ads/Settings$Value;

    .line 237
    .local v3, "value":Lcom/amazon/device/ads/Settings$Value;
    iget-boolean v4, v3, Lcom/amazon/device/ads/Settings$Value;->isTransientData:Z

    if-nez v4, :cond_0

    .line 242
    iget-object v4, v3, Lcom/amazon/device/ads/Settings$Value;->clazz:Ljava/lang/Class;

    const-class v5, Ljava/lang/String;

    if-ne v4, v5, :cond_1

    .line 244
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    iget-object v5, v3, Lcom/amazon/device/ads/Settings$Value;->value:Ljava/lang/Object;

    check-cast v5, Ljava/lang/String;

    invoke-interface {v0, v4, v5}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    goto :goto_0

    .line 246
    :cond_1
    iget-object v4, v3, Lcom/amazon/device/ads/Settings$Value;->clazz:Ljava/lang/Class;

    const-class v5, Ljava/lang/Long;

    if-ne v4, v5, :cond_2

    .line 248
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    iget-object v5, v3, Lcom/amazon/device/ads/Settings$Value;->value:Ljava/lang/Object;

    check-cast v5, Ljava/lang/Long;

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    invoke-interface {v0, v4, v5, v6}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    goto :goto_0

    .line 250
    :cond_2
    iget-object v4, v3, Lcom/amazon/device/ads/Settings$Value;->clazz:Ljava/lang/Class;

    const-class v5, Ljava/lang/Integer;

    if-ne v4, v5, :cond_3

    .line 252
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    iget-object v5, v3, Lcom/amazon/device/ads/Settings$Value;->value:Ljava/lang/Object;

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-interface {v0, v4, v5}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    goto :goto_0

    .line 254
    :cond_3
    iget-object v4, v3, Lcom/amazon/device/ads/Settings$Value;->clazz:Ljava/lang/Class;

    const-class v5, Ljava/lang/Boolean;

    if-ne v4, v5, :cond_0

    .line 256
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    iget-object v5, v3, Lcom/amazon/device/ads/Settings$Value;->value:Ljava/lang/Object;

    check-cast v5, Ljava/lang/Boolean;

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    invoke-interface {v0, v4, v5}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    goto :goto_0

    .line 259
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/device/ads/Settings$Value;>;"
    .end local v3    # "value":Lcom/amazon/device/ads/Settings$Value;
    :cond_4
    iget-object v4, p0, Lcom/amazon/device/ads/Settings$2;->this$0:Lcom/amazon/device/ads/Settings;

    # invokes: Lcom/amazon/device/ads/Settings;->commit(Landroid/content/SharedPreferences$Editor;)V
    invoke-static {v4, v0}, Lcom/amazon/device/ads/Settings;->access$200(Lcom/amazon/device/ads/Settings;Landroid/content/SharedPreferences$Editor;)V

    .line 260
    iget-object v4, p0, Lcom/amazon/device/ads/Settings$2;->this$0:Lcom/amazon/device/ads/Settings;

    # getter for: Lcom/amazon/device/ads/Settings;->writeToSharedPreferencesLock:Ljava/util/concurrent/locks/ReentrantLock;
    invoke-static {v4}, Lcom/amazon/device/ads/Settings;->access$000(Lcom/amazon/device/ads/Settings;)Ljava/util/concurrent/locks/ReentrantLock;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 261
    return-void
.end method
