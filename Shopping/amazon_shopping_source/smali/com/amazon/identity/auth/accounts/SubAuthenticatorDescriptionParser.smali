.class public Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser;
.super Ljava/lang/Object;
.source "SubAuthenticatorDescriptionParser.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$1;,
        Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    return-void
.end method


# virtual methods
.method public parse(Ljava/lang/String;Ljava/lang/String;Landroid/content/res/XmlResourceParser;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    .locals 2
    .param p1, "packageName"    # Ljava/lang/String;
    .param p2, "className"    # Ljava/lang/String;
    .param p3, "xmlParser"    # Landroid/content/res/XmlResourceParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;
        }
    .end annotation

    .prologue
    .line 25
    if-eqz p1, :cond_0

    if-nez p3, :cond_1

    .line 27
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The package name and xml parser parameter cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 30
    :cond_1
    new-instance v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;-><init>(Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$1;)V

    .line 31
    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->parse(Ljava/lang/String;Ljava/lang/String;Landroid/content/res/XmlResourceParser;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    move-result-object v0

    return-object v0
.end method
