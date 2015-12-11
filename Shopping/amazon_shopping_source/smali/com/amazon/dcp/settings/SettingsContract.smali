.class public final Lcom/amazon/dcp/settings/SettingsContract;
.super Ljava/lang/Object;
.source "SettingsContract.java"


# static fields
.field public static final AUTHORITY_URI:Landroid/net/Uri;

.field public static final VALUES_CONTENT_URI:Landroid/net/Uri;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 17
    const-string/jumbo v0, "content://com.amazon.dcp.settings"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/amazon/dcp/settings/SettingsContract;->AUTHORITY_URI:Landroid/net/Uri;

    .line 19
    sget-object v0, Lcom/amazon/dcp/settings/SettingsContract;->AUTHORITY_URI:Landroid/net/Uri;

    const-string/jumbo v1, "values"

    invoke-static {v0, v1}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/amazon/dcp/settings/SettingsContract;->VALUES_CONTENT_URI:Landroid/net/Uri;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    return-void
.end method

.method public static getAppLocalNamespace(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 38
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
