.class public final enum Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;
.super Ljava/lang/Enum;
.source "CORPFMResponse.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/attributes/CORPFMResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ComputationConfidenceValue"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

.field public static final enum CUSTOMER_BASED_GUESS:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

.field public static final enum CUSTOMER_PROVIDED:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

.field public static final enum DEVICE_BASED_GUESS:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

.field private static final LOOKUP_BY_VALUE:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mIsGuess:Z

.field private final mValue:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 10

    .prologue
    const/4 v9, 0x2

    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 13
    new-instance v4, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    const-string/jumbo v5, "CUSTOMER_PROVIDED"

    const-string/jumbo v6, "CUSTOMER_PROVIDED"

    invoke-direct {v4, v5, v8, v6, v8}, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v4, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->CUSTOMER_PROVIDED:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    .line 14
    new-instance v4, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    const-string/jumbo v5, "CUSTOMER_BASED_GUESS"

    const-string/jumbo v6, "CUSTOMER_BASED_GUESS"

    invoke-direct {v4, v5, v7, v6, v7}, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v4, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->CUSTOMER_BASED_GUESS:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    .line 15
    new-instance v4, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    const-string/jumbo v5, "DEVICE_BASED_GUESS"

    const-string/jumbo v6, "DEVICE_BASED_GUESS"

    invoke-direct {v4, v5, v9, v6, v7}, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v4, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->DEVICE_BASED_GUESS:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    .line 11
    const/4 v4, 0x3

    new-array v4, v4, [Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    sget-object v5, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->CUSTOMER_PROVIDED:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    aput-object v5, v4, v8

    sget-object v5, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->CUSTOMER_BASED_GUESS:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    aput-object v5, v4, v7

    sget-object v5, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->DEVICE_BASED_GUESS:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    aput-object v5, v4, v9

    sput-object v4, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->$VALUES:[Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    .line 17
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    sput-object v4, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->LOOKUP_BY_VALUE:Ljava/util/Map;

    .line 21
    invoke-static {}, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->values()[Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v3, v0, v1

    .line 23
    .local v3, "type":Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;
    sget-object v4, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->LOOKUP_BY_VALUE:Ljava/util/Map;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->getValue()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 21
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 25
    .end local v3    # "type":Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;
    :cond_0
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 0
    .param p3, "value"    # Ljava/lang/String;
    .param p4, "isGuess"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 31
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 32
    iput-object p3, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->mValue:Ljava/lang/String;

    .line 33
    iput-boolean p4, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->mIsGuess:Z

    .line 34
    return-void
.end method

.method public static parseFromValue(Ljava/lang/String;Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;)Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;
    .locals 2
    .param p0, "value"    # Ljava/lang/String;
    .param p1, "defaultValue"    # Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    .prologue
    .line 49
    sget-object v1, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->LOOKUP_BY_VALUE:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    .line 50
    .local v0, "confidenceValue":Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;
    if-eqz v0, :cond_0

    .line 55
    .end local v0    # "confidenceValue":Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;
    :goto_0
    return-object v0

    .restart local v0    # "confidenceValue":Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;
    :cond_0
    move-object v0, p1

    goto :goto_0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->$VALUES:[Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    return-object v0
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->mValue:Ljava/lang/String;

    return-object v0
.end method

.method public isGuess()Z
    .locals 1

    .prologue
    .line 43
    iget-boolean v0, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->mIsGuess:Z

    return v0
.end method
