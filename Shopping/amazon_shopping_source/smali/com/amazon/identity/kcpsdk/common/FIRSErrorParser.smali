.class public final Lcom/amazon/identity/kcpsdk/common/FIRSErrorParser;
.super Ljava/lang/Object;
.source "FIRSErrorParser.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const-class v0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorParser;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorParser;->TAG:Ljava/lang/String;

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

.method public static parseError(Lorg/w3c/dom/Document;)Lcom/amazon/identity/kcpsdk/common/FIRSError;
    .locals 5
    .param p0, "xmlDocument"    # Lorg/w3c/dom/Document;

    .prologue
    .line 19
    invoke-interface {p0}, Lorg/w3c/dom/Document;->getDocumentElement()Lorg/w3c/dom/Element;

    move-result-object v0

    .line 21
    .local v0, "errorNode":Lorg/w3c/dom/Element;
    if-eqz v0, :cond_0

    invoke-interface {v0}, Lorg/w3c/dom/Element;->getTagName()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "error"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 23
    :cond_0
    const/4 v2, 0x0

    .line 56
    :goto_0
    return-object v2

    .line 27
    :cond_1
    sget-object v2, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeCustomerNotFound:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->getErrorCode()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->hasElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 29
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeCustomerNotFound:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    .line 54
    .local v1, "errorType":Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;
    :goto_1
    sget-object v2, Lcom/amazon/identity/kcpsdk/common/FIRSErrorParser;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "FIRSError type="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 56
    new-instance v2, Lcom/amazon/identity/kcpsdk/common/FIRSError;

    invoke-direct {v2, v1}, Lcom/amazon/identity/kcpsdk/common/FIRSError;-><init>(Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;)V

    goto :goto_0

    .line 31
    .end local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;
    :cond_2
    sget-object v2, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeDeviceAlreadyRegistered:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->getErrorCode()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->hasElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 34
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeDeviceAlreadyRegistered:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    .restart local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;
    goto :goto_1

    .line 36
    .end local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;
    :cond_3
    sget-object v2, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeDuplicateAccountName:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->getErrorCode()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->hasElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 39
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeDuplicateAccountName:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    .restart local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;
    goto :goto_1

    .line 41
    .end local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;
    :cond_4
    sget-object v2, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeInternalError:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->getErrorCode()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->hasElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 43
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeInternalError:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    .restart local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;
    goto :goto_1

    .line 45
    .end local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;
    :cond_5
    sget-object v2, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeInvalidAccountFound:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->getErrorCode()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->hasElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 48
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeInvalidAccountFound:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    .restart local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;
    goto :goto_1

    .line 52
    .end local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;
    :cond_6
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeUnrecognized:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    .restart local v1    # "errorType":Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;
    goto :goto_1
.end method
