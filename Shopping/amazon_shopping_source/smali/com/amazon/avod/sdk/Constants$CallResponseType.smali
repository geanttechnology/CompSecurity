.class public final enum Lcom/amazon/avod/sdk/Constants$CallResponseType;
.super Ljava/lang/Enum;
.source "Constants.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/avod/sdk/Constants;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "CallResponseType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/avod/sdk/Constants$CallResponseType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/avod/sdk/Constants$CallResponseType;

.field public static final enum FAILURE:Lcom/amazon/avod/sdk/Constants$CallResponseType;

.field private static final RESPONSE_CODE_MAP:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/amazon/avod/sdk/Constants$CallResponseType;",
            ">;"
        }
    .end annotation
.end field

.field public static final enum SUCCESS:Lcom/amazon/avod/sdk/Constants$CallResponseType;


# instance fields
.field private final mCode:I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 63
    new-instance v0, Lcom/amazon/avod/sdk/Constants$CallResponseType;

    const-string/jumbo v1, "SUCCESS"

    invoke-direct {v0, v1, v2, v2}, Lcom/amazon/avod/sdk/Constants$CallResponseType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/avod/sdk/Constants$CallResponseType;->SUCCESS:Lcom/amazon/avod/sdk/Constants$CallResponseType;

    .line 64
    new-instance v0, Lcom/amazon/avod/sdk/Constants$CallResponseType;

    const-string/jumbo v1, "FAILURE"

    invoke-direct {v0, v1, v3, v3}, Lcom/amazon/avod/sdk/Constants$CallResponseType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/avod/sdk/Constants$CallResponseType;->FAILURE:Lcom/amazon/avod/sdk/Constants$CallResponseType;

    .line 62
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/avod/sdk/Constants$CallResponseType;

    sget-object v1, Lcom/amazon/avod/sdk/Constants$CallResponseType;->SUCCESS:Lcom/amazon/avod/sdk/Constants$CallResponseType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/avod/sdk/Constants$CallResponseType;->FAILURE:Lcom/amazon/avod/sdk/Constants$CallResponseType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/avod/sdk/Constants$CallResponseType;->$VALUES:[Lcom/amazon/avod/sdk/Constants$CallResponseType;

    .line 66
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/avod/sdk/Constants$CallResponseType;->RESPONSE_CODE_MAP:Ljava/util/Map;

    .line 68
    sget-object v0, Lcom/amazon/avod/sdk/Constants$CallResponseType;->RESPONSE_CODE_MAP:Ljava/util/Map;

    sget-object v1, Lcom/amazon/avod/sdk/Constants$CallResponseType;->SUCCESS:Lcom/amazon/avod/sdk/Constants$CallResponseType;

    invoke-virtual {v1}, Lcom/amazon/avod/sdk/Constants$CallResponseType;->getResponseCode()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    sget-object v2, Lcom/amazon/avod/sdk/Constants$CallResponseType;->SUCCESS:Lcom/amazon/avod/sdk/Constants$CallResponseType;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 69
    sget-object v0, Lcom/amazon/avod/sdk/Constants$CallResponseType;->RESPONSE_CODE_MAP:Ljava/util/Map;

    sget-object v1, Lcom/amazon/avod/sdk/Constants$CallResponseType;->FAILURE:Lcom/amazon/avod/sdk/Constants$CallResponseType;

    invoke-virtual {v1}, Lcom/amazon/avod/sdk/Constants$CallResponseType;->getResponseCode()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    sget-object v2, Lcom/amazon/avod/sdk/Constants$CallResponseType;->FAILURE:Lcom/amazon/avod/sdk/Constants$CallResponseType;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 70
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "code"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 74
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 75
    iput p3, p0, Lcom/amazon/avod/sdk/Constants$CallResponseType;->mCode:I

    .line 76
    return-void
.end method

.method public static fromResponseCode(I)Lcom/amazon/avod/sdk/Constants$CallResponseType;
    .locals 2
    .param p0, "responseCode"    # I

    .prologue
    .line 88
    sget-object v0, Lcom/amazon/avod/sdk/Constants$CallResponseType;->RESPONSE_CODE_MAP:Ljava/util/Map;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/avod/sdk/Constants$CallResponseType;

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/avod/sdk/Constants$CallResponseType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 62
    const-class v0, Lcom/amazon/avod/sdk/Constants$CallResponseType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/avod/sdk/Constants$CallResponseType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/avod/sdk/Constants$CallResponseType;
    .locals 1

    .prologue
    .line 62
    sget-object v0, Lcom/amazon/avod/sdk/Constants$CallResponseType;->$VALUES:[Lcom/amazon/avod/sdk/Constants$CallResponseType;

    invoke-virtual {v0}, [Lcom/amazon/avod/sdk/Constants$CallResponseType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/avod/sdk/Constants$CallResponseType;

    return-object v0
.end method


# virtual methods
.method public getResponseCode()I
    .locals 1

    .prologue
    .line 79
    iget v0, p0, Lcom/amazon/avod/sdk/Constants$CallResponseType;->mCode:I

    return v0
.end method
