.class public Lcom/amazon/rio/j2me/client/services/ApplicationException;
.super Ljava/lang/Exception;
.source "ApplicationException.java"


# static fields
.field public static final AGE_NOT_DECLARED:Ljava/lang/String;

.field public static final BLACK_CURTAIN:Ljava/lang/String;

.field public static final CLIENT_UPGRADE_REQUIRED:Ljava/lang/String;

.field private static final CODES:[Ljava/lang/String;

.field public static final DOB_REQUIRED:Ljava/lang/String;

.field private static final EXPLANATIONS:[Ljava/lang/String;

.field public static final INTERNAL_ERROR:Ljava/lang/String;

.field public static final OPERATION_NO_LONGER_SUPPORTED:Ljava/lang/String;

.field public static final USER_NOT_AUTHENTICATED:Ljava/lang/String;


# instance fields
.field private final errorCode:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 17
    const-string/jumbo v0, "Age_Not_Declared"

    invoke-virtual {v0}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/rio/j2me/client/services/ApplicationException;->AGE_NOT_DECLARED:Ljava/lang/String;

    .line 18
    const-string/jumbo v0, "Black_Curtain"

    invoke-virtual {v0}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/rio/j2me/client/services/ApplicationException;->BLACK_CURTAIN:Ljava/lang/String;

    .line 19
    const-string/jumbo v0, "Client_Upgrade_Required"

    invoke-virtual {v0}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/rio/j2me/client/services/ApplicationException;->CLIENT_UPGRADE_REQUIRED:Ljava/lang/String;

    .line 20
    const-string/jumbo v0, "DOB_Required"

    invoke-virtual {v0}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/rio/j2me/client/services/ApplicationException;->DOB_REQUIRED:Ljava/lang/String;

    .line 21
    const-string/jumbo v0, "Internal_Error"

    invoke-virtual {v0}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/rio/j2me/client/services/ApplicationException;->INTERNAL_ERROR:Ljava/lang/String;

    .line 22
    const-string/jumbo v0, "Operation_No_Longer_Supported"

    invoke-virtual {v0}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/rio/j2me/client/services/ApplicationException;->OPERATION_NO_LONGER_SUPPORTED:Ljava/lang/String;

    .line 23
    const-string/jumbo v0, "User_Not_Authenticated"

    invoke-virtual {v0}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/rio/j2me/client/services/ApplicationException;->USER_NOT_AUTHENTICATED:Ljava/lang/String;

    .line 26
    const/4 v0, 0x7

    new-array v0, v0, [Ljava/lang/String;

    sget-object v1, Lcom/amazon/rio/j2me/client/services/ApplicationException;->AGE_NOT_DECLARED:Ljava/lang/String;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/rio/j2me/client/services/ApplicationException;->BLACK_CURTAIN:Ljava/lang/String;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/rio/j2me/client/services/ApplicationException;->CLIENT_UPGRADE_REQUIRED:Ljava/lang/String;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/rio/j2me/client/services/ApplicationException;->DOB_REQUIRED:Ljava/lang/String;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/rio/j2me/client/services/ApplicationException;->INTERNAL_ERROR:Ljava/lang/String;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/rio/j2me/client/services/ApplicationException;->OPERATION_NO_LONGER_SUPPORTED:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/rio/j2me/client/services/ApplicationException;->USER_NOT_AUTHENTICATED:Ljava/lang/String;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/rio/j2me/client/services/ApplicationException;->CODES:[Ljava/lang/String;

    .line 38
    const/4 v0, 0x7

    new-array v0, v0, [Ljava/lang/String;

    const-string/jumbo v1, "Must declare age."

    aput-object v1, v0, v3

    const-string/jumbo v1, "Must be an adult"

    aput-object v1, v0, v4

    const-string/jumbo v1, "App must be upgraded to the new version"

    aput-object v1, v0, v5

    const-string/jumbo v1, "Must provide a date of birth"

    aput-object v1, v0, v6

    const-string/jumbo v1, "Request could not be fulfilled"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string/jumbo v2, "Operation is disabled"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string/jumbo v2, "User not authenticated"

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/rio/j2me/client/services/ApplicationException;->EXPLANATIONS:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "errorCode"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 64
    invoke-direct {p0, p2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 65
    if-nez p2, :cond_0

    .line 66
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Message cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 67
    :cond_0
    invoke-virtual {p1}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/services/ApplicationException;->errorCode:Ljava/lang/String;

    .line 68
    return-void
.end method

.method private static final explanationFromCode(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "code"    # Ljava/lang/String;

    .prologue
    .line 52
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    sget-object v1, Lcom/amazon/rio/j2me/client/services/ApplicationException;->CODES:[Ljava/lang/String;

    array-length v1, v1

    if-ge v0, v1, :cond_1

    .line 53
    sget-object v1, Lcom/amazon/rio/j2me/client/services/ApplicationException;->CODES:[Ljava/lang/String;

    aget-object v1, v1, v0

    if-ne p0, v1, :cond_0

    .line 54
    sget-object v1, Lcom/amazon/rio/j2me/client/services/ApplicationException;->EXPLANATIONS:[Ljava/lang/String;

    aget-object v1, v1, v0

    .line 55
    :goto_1
    return-object v1

    .line 52
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 55
    :cond_1
    const-string/jumbo v1, "<Unrecognized code>"

    goto :goto_1
.end method


# virtual methods
.method public getErrorCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/ApplicationException;->errorCode:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 77
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/ApplicationException;->getMessage()Ljava/lang/String;

    move-result-object v0

    .line 78
    .local v0, "msg":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ": "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/ApplicationException;->getErrorCode()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/rio/j2me/client/services/ApplicationException;->explanationFromCode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string/jumbo v1, ""

    :goto_0
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, " - "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method
