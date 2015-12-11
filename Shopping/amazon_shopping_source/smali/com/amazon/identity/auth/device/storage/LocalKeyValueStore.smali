.class public Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;
.super Ljava/lang/Object;
.source "LocalKeyValueStore.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mSharedPrefs:Landroid/content/SharedPreferences;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const-class v0, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "namespace"    # Ljava/lang/String;

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    const/4 v0, 0x0

    invoke-virtual {p1, p2, v0}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->mSharedPrefs:Landroid/content/SharedPreferences;

    .line 18
    return-void
.end method


# virtual methods
.method public clearStore()Z
    .locals 3

    .prologue
    .line 38
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->mSharedPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v0

    .line 39
    .local v0, "success":Z
    if-nez v0, :cond_0

    .line 41
    sget-object v1, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Failed to clear the local key value store"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    :cond_0
    return v0
.end method

.method public getValue(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->mSharedPrefs:Landroid/content/SharedPreferences;

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public setValue(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 5
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 27
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->mSharedPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v0

    .line 28
    .local v0, "success":Z
    if-nez v0, :cond_0

    .line 30
    sget-object v1, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Failed to set key %s in the local key value store"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 33
    :cond_0
    return v0
.end method
