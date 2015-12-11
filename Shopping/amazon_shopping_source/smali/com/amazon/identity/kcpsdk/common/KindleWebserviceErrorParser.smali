.class public final Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorParser;
.super Ljava/lang/Object;
.source "KindleWebserviceErrorParser.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const-class v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorParser;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorParser;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    return-void
.end method

.method public static parseError(Lorg/w3c/dom/Document;)Lcom/amazon/identity/kcpsdk/common/KindleWebserviceError;
    .locals 5
    .param p0, "xmlDocument"    # Lorg/w3c/dom/Document;

    .prologue
    .line 19
    invoke-interface {p0}, Lorg/w3c/dom/Document;->getDocumentElement()Lorg/w3c/dom/Element;

    move-result-object v0

    .line 20
    .local v0, "errorNode":Lorg/w3c/dom/Element;
    if-eqz v0, :cond_0

    invoke-interface {v0}, Lorg/w3c/dom/Element;->getTagName()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "KindleWebServicesError"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 23
    :cond_0
    const/4 v2, 0x0

    .line 73
    :goto_0
    return-object v2

    .line 28
    :cond_1
    const-string/jumbo v2, "FileNotFoundError"

    invoke-static {v0, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->hasElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 30
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeFileNotFound:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .line 72
    .local v1, "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    :goto_1
    sget-object v2, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorParser;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "KindleWebserviceError type="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    new-instance v2, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceError;

    invoke-direct {v2, v1}, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceError;-><init>(Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;)V

    goto :goto_0

    .line 32
    .end local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    :cond_2
    const-string/jumbo v2, "DeviceAlreadyRegistered"

    invoke-static {v0, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->hasElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 34
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeDeviceAlreadyRegistered:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .restart local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    goto :goto_1

    .line 36
    .end local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    :cond_3
    const-string/jumbo v2, "CredentialsRequired"

    invoke-static {v0, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->hasElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 38
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeCredentialsRequired:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .restart local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    goto :goto_1

    .line 40
    .end local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    :cond_4
    const-string/jumbo v2, "InvalidAsin"

    invoke-static {v0, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->hasElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 42
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeInvalidAsin:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .restart local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    goto :goto_1

    .line 44
    .end local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    :cond_5
    const-string/jumbo v2, "InvalidOrder"

    invoke-static {v0, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->hasElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 46
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeInvalidOrder:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .restart local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    goto :goto_1

    .line 48
    .end local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    :cond_6
    const-string/jumbo v2, "InsufficientFunds"

    invoke-static {v0, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->hasElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 50
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeInsufficientFunds:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .restart local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    goto :goto_1

    .line 52
    .end local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    :cond_7
    const-string/jumbo v2, "UnknownError"

    invoke-static {v0, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->hasElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_8

    .line 54
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeUnknownError:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .restart local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    goto :goto_1

    .line 56
    .end local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    :cond_8
    const-string/jumbo v2, "UnBuyError"

    invoke-static {v0, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->hasElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 58
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeUnbuyError:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .restart local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    goto :goto_1

    .line 60
    .end local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    :cond_9
    const-string/jumbo v2, "DuplicateDeviceName"

    invoke-static {v0, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->hasElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 62
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeDuplicateDeviceName:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .restart local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    goto :goto_1

    .line 64
    .end local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    :cond_a
    const-string/jumbo v2, "InternalError"

    invoke-static {v0, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->hasElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 66
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeInternalError:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .restart local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    goto/16 :goto_1

    .line 70
    .end local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    :cond_b
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeUnrecognized:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .restart local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    goto/16 :goto_1
.end method
