.class public Lco/vine/android/util/CrossAnalytics;
.super Ljava/lang/Object;
.source "CrossAnalytics.java"


# static fields
.field private static final PREF_NAME:Ljava/lang/String; = "cross_analytics"

.field public static final PRE_INSTALL_SIGN_UP:Ljava/lang/String; = "pre_install_sign up"

.field private static sINSTANCE:Lco/vine/android/util/CrossAnalytics;


# instance fields
.field private final mPrefs:Landroid/content/SharedPreferences;


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    const-string v0, "cross_analytics"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/util/CrossAnalytics;->mPrefs:Landroid/content/SharedPreferences;

    .line 20
    return-void
.end method

.method public static getInstance(Landroid/content/Context;)Lco/vine/android/util/CrossAnalytics;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 23
    sget-object v0, Lco/vine/android/util/CrossAnalytics;->sINSTANCE:Lco/vine/android/util/CrossAnalytics;

    if-nez v0, :cond_0

    .line 24
    new-instance v0, Lco/vine/android/util/CrossAnalytics;

    invoke-direct {v0, p0}, Lco/vine/android/util/CrossAnalytics;-><init>(Landroid/content/Context;)V

    sput-object v0, Lco/vine/android/util/CrossAnalytics;->sINSTANCE:Lco/vine/android/util/CrossAnalytics;

    .line 26
    :cond_0
    sget-object v0, Lco/vine/android/util/CrossAnalytics;->sINSTANCE:Lco/vine/android/util/CrossAnalytics;

    return-object v0
.end method


# virtual methods
.method public clear(Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 34
    iget-object v0, p0, Lco/vine/android/util/CrossAnalytics;->mPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 35
    return-void
.end method

.method public get(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 38
    iget-object v0, p0, Lco/vine/android/util/CrossAnalytics;->mPrefs:Landroid/content/SharedPreferences;

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isSet(Ljava/lang/String;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 42
    invoke-virtual {p0, p1}, Lco/vine/android/util/CrossAnalytics;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public set(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 30
    iget-object v0, p0, Lco/vine/android/util/CrossAnalytics;->mPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 31
    return-void
.end method
