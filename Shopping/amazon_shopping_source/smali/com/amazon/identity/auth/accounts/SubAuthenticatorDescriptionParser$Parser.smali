.class Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;
.super Ljava/lang/Object;
.source "SubAuthenticatorDescriptionParser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Parser"
.end annotation


# instance fields
.field private mDeviceType:Ljava/lang/String;

.field private mIsDMS:Z

.field private mIsMultipleAccountAware:Z

.field private final mTokenTypes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mXmlParser:Landroid/content/res/XmlResourceParser;


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mTokenTypes:Ljava/util/List;

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$1;

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;-><init>()V

    return-void
.end method

.method private assertNodeName(Ljava/lang/String;)V
    .locals 1
    .param p1, "expectedName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;
        }
    .end annotation

    .prologue
    .line 216
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mXmlParser:Landroid/content/res/XmlResourceParser;

    invoke-interface {v0}, Landroid/content/res/XmlResourceParser;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 218
    new-instance v0, Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;

    invoke-direct {v0}, Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;-><init>()V

    throw v0

    .line 220
    :cond_0
    return-void
.end method

.method private moveNextAndCheck(I)V
    .locals 2
    .param p1, "expectedEvent"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;,
            Ljava/io/IOException;,
            Lorg/xmlpull/v1/XmlPullParserException;
        }
    .end annotation

    .prologue
    .line 106
    const/4 v1, 0x2

    if-eq p1, v1, :cond_0

    const/4 v1, 0x3

    if-ne p1, v1, :cond_1

    .line 108
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mXmlParser:Landroid/content/res/XmlResourceParser;

    invoke-interface {v1}, Landroid/content/res/XmlResourceParser;->nextTag()I

    move-result v0

    .line 115
    .local v0, "eventType":I
    :goto_0
    if-eq v0, p1, :cond_2

    .line 117
    new-instance v1, Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;

    invoke-direct {v1}, Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;-><init>()V

    throw v1

    .line 112
    .end local v0    # "eventType":I
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mXmlParser:Landroid/content/res/XmlResourceParser;

    invoke-interface {v1}, Landroid/content/res/XmlResourceParser;->next()I

    move-result v0

    .restart local v0    # "eventType":I
    goto :goto_0

    .line 119
    :cond_2
    return-void
.end method

.method private startNode(Ljava/lang/String;)V
    .locals 1
    .param p1, "expectedName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;,
            Ljava/io/IOException;,
            Lorg/xmlpull/v1/XmlPullParserException;
        }
    .end annotation

    .prologue
    .line 209
    const/4 v0, 0x2

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->moveNextAndCheck(I)V

    .line 211
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->assertNodeName(Ljava/lang/String;)V

    .line 212
    return-void
.end method


# virtual methods
.method public parse(Ljava/lang/String;Ljava/lang/String;Landroid/content/res/XmlResourceParser;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    .locals 5
    .param p1, "packageName"    # Ljava/lang/String;
    .param p2, "className"    # Ljava/lang/String;
    .param p3, "parser"    # Landroid/content/res/XmlResourceParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x3

    .line 48
    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mXmlParser:Landroid/content/res/XmlResourceParser;

    .line 52
    const/4 v1, 0x0

    :try_start_0
    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->moveNextAndCheck(I)V

    const-string/jumbo v1, "account-sub-authenticator"

    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->startNode(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mXmlParser:Landroid/content/res/XmlResourceParser;

    const/4 v2, 0x0

    const-string/jumbo v3, "accountType"

    invoke-interface {v1, v2, v3}, Landroid/content/res/XmlResourceParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "com.amazon.account"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    new-instance v1, Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;

    invoke-direct {v1}, Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;-><init>()V

    throw v1
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 69
    :catch_0
    move-exception v0

    .line 71
    .local v0, "e":Lorg/xmlpull/v1/XmlPullParserException;
    new-instance v1, Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;

    invoke-direct {v1, v0}, Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;-><init>(Ljava/lang/Exception;)V

    throw v1

    .line 52
    .end local v0    # "e":Lorg/xmlpull/v1/XmlPullParserException;
    :cond_0
    :try_start_1
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mXmlParser:Landroid/content/res/XmlResourceParser;

    const/4 v2, 0x0

    const-string/jumbo v3, "type"

    invoke-interface {v1, v2, v3}, Landroid/content/res/XmlResourceParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3

    const-string/jumbo v2, "DMS"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mIsDMS:Z

    :goto_0
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mXmlParser:Landroid/content/res/XmlResourceParser;

    invoke-interface {v1}, Landroid/content/res/XmlResourceParser;->next()I

    move-result v1

    if-eq v1, v4, :cond_5

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mXmlParser:Landroid/content/res/XmlResourceParser;

    invoke-interface {v1}, Landroid/content/res/XmlResourceParser;->getName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x4

    invoke-direct {p0, v2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->moveNextAndCheck(I)V

    const-string/jumbo v2, "device-type"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mXmlParser:Landroid/content/res/XmlResourceParser;

    invoke-interface {v1}, Landroid/content/res/XmlResourceParser;->getText()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mDeviceType:Ljava/lang/String;

    :goto_1
    const/4 v1, 0x3

    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->moveNextAndCheck(I)V
    :try_end_1
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 73
    :catch_1
    move-exception v0

    .line 75
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;

    invoke-direct {v1, v0}, Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;-><init>(Ljava/lang/Exception;)V

    throw v1

    .line 52
    .end local v0    # "e":Ljava/io/IOException;
    :cond_1
    :try_start_2
    const-string/jumbo v2, "multiple-account-aware"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mXmlParser:Landroid/content/res/XmlResourceParser;

    invoke-interface {v1}, Landroid/content/res/XmlResourceParser;->getText()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/StringConversionHelpers;->toBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mIsMultipleAccountAware:Z

    goto :goto_1

    :cond_2
    new-instance v1, Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;

    invoke-direct {v1}, Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;-><init>()V

    throw v1

    :cond_3
    const-string/jumbo v1, "token-types"

    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->startNode(Ljava/lang/String;)V

    :goto_2
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mXmlParser:Landroid/content/res/XmlResourceParser;

    invoke-interface {v1}, Landroid/content/res/XmlResourceParser;->nextTag()I

    move-result v1

    if-eq v1, v4, :cond_4

    const-string/jumbo v1, "token-type"

    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->assertNodeName(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mXmlParser:Landroid/content/res/XmlResourceParser;

    const/4 v2, 0x0

    const-string/jumbo v3, "name"

    invoke-interface {v1, v2, v3}, Landroid/content/res/XmlResourceParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x3

    invoke-direct {p0, v2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->moveNextAndCheck(I)V

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mTokenTypes:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    :cond_4
    const-string/jumbo v1, "token-types"

    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->assertNodeName(Ljava/lang/String;)V

    :cond_5
    const-string/jumbo v1, "account-sub-authenticator"

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mXmlParser:Landroid/content/res/XmlResourceParser;

    invoke-interface {v2}, Landroid/content/res/XmlResourceParser;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_6

    const/4 v1, 0x3

    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->moveNextAndCheck(I)V

    :cond_6
    const/4 v1, 0x1

    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->moveNextAndCheck(I)V

    .line 54
    iget-boolean v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mIsDMS:Z

    if-eqz v1, :cond_7

    .line 56
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mDeviceType:Ljava/lang/String;

    iget-boolean v2, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mIsMultipleAccountAware:Z

    invoke-static {p1, p2, v1, v2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->createDMSSubAuthenticatorDescription(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    move-result-object v1

    .line 63
    :goto_3
    return-object v1

    :cond_7
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser$Parser;->mTokenTypes:Ljava/util/List;

    invoke-static {p1, p2, v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->createNonDMSSubAuthenticatorDescription(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    :try_end_2
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    move-result-object v1

    goto :goto_3
.end method
