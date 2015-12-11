.class public Lcom/poshmark/controllers/SharedPreferencesController;
.super Ljava/lang/Object;
.source "SharedPreferencesController.java"


# static fields
.field private static final SHARED_PREF_NAME:Ljava/lang/String; = "poshmark_pref"

.field static sharedPreferenceController:Lcom/poshmark/controllers/SharedPreferencesController;


# instance fields
.field editor:Landroid/content/SharedPreferences$Editor;

.field sharedPreferences:Landroid/content/SharedPreferences;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const/4 v0, 0x0

    sput-object v0, Lcom/poshmark/controllers/SharedPreferencesController;->sharedPreferenceController:Lcom/poshmark/controllers/SharedPreferencesController;

    return-void
.end method

.method constructor <init>()V
    .locals 3

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "poshmark_pref"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/controllers/SharedPreferencesController;->sharedPreferences:Landroid/content/SharedPreferences;

    .line 33
    iget-object v0, p0, Lcom/poshmark/controllers/SharedPreferencesController;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/controllers/SharedPreferencesController;->editor:Landroid/content/SharedPreferences$Editor;

    .line 34
    return-void
.end method

.method public static getSharedPreferencesController()Lcom/poshmark/controllers/SharedPreferencesController;
    .locals 1

    .prologue
    .line 23
    sget-object v0, Lcom/poshmark/controllers/SharedPreferencesController;->sharedPreferenceController:Lcom/poshmark/controllers/SharedPreferencesController;

    if-nez v0, :cond_0

    .line 24
    new-instance v0, Lcom/poshmark/controllers/SharedPreferencesController;

    invoke-direct {v0}, Lcom/poshmark/controllers/SharedPreferencesController;-><init>()V

    sput-object v0, Lcom/poshmark/controllers/SharedPreferencesController;->sharedPreferenceController:Lcom/poshmark/controllers/SharedPreferencesController;

    .line 26
    :cond_0
    sget-object v0, Lcom/poshmark/controllers/SharedPreferencesController;->sharedPreferenceController:Lcom/poshmark/controllers/SharedPreferencesController;

    return-object v0
.end method


# virtual methods
.method public getSharedPreferences()Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/poshmark/controllers/SharedPreferencesController;->sharedPreferences:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method public getSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/poshmark/controllers/SharedPreferencesController;->editor:Landroid/content/SharedPreferences$Editor;

    return-object v0
.end method

.method public getStringSet(Ljava/lang/String;)Ljava/util/Set;
    .locals 2
    .param p1, "preferenceName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 56
    iget-object v0, p0, Lcom/poshmark/controllers/SharedPreferencesController;->sharedPreferences:Landroid/content/SharedPreferences;

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getStringSet(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public putStringSet(Ljava/lang/String;Ljava/util/Set;)V
    .locals 1
    .param p1, "preferenceName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 50
    .local p2, "set":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/poshmark/controllers/SharedPreferencesController;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putStringSet(Ljava/lang/String;Ljava/util/Set;)Landroid/content/SharedPreferences$Editor;

    .line 51
    iget-object v0, p0, Lcom/poshmark/controllers/SharedPreferencesController;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 52
    return-void
.end method

.method public removePreference(Ljava/lang/String;)V
    .locals 1
    .param p1, "preferenceName"    # Ljava/lang/String;

    .prologue
    .line 61
    iget-object v0, p0, Lcom/poshmark/controllers/SharedPreferencesController;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0, p1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 62
    iget-object v0, p0, Lcom/poshmark/controllers/SharedPreferencesController;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 63
    return-void
.end method
