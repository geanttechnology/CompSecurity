.class Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry$DMSPackageInfo;
.super Ljava/lang/Object;
.source "SubAuthenticatorRegistry.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "DMSPackageInfo"
.end annotation


# instance fields
.field private mPackageName:Ljava/lang/String;

.field private mParser:Landroid/content/res/XmlResourceParser;


# direct methods
.method public constructor <init>(Ljava/lang/String;Landroid/content/res/XmlResourceParser;)V
    .locals 0
    .param p1, "newPackageName"    # Ljava/lang/String;
    .param p2, "newParser"    # Landroid/content/res/XmlResourceParser;

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry$DMSPackageInfo;->mPackageName:Ljava/lang/String;

    .line 44
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry$DMSPackageInfo;->mParser:Landroid/content/res/XmlResourceParser;

    .line 45
    return-void
.end method


# virtual methods
.method public getPackageName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry$DMSPackageInfo;->mPackageName:Ljava/lang/String;

    return-object v0
.end method

.method public getParser()Landroid/content/res/XmlResourceParser;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry$DMSPackageInfo;->mParser:Landroid/content/res/XmlResourceParser;

    return-object v0
.end method
