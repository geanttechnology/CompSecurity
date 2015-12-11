.class public final enum Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;
.super Ljava/lang/Enum;
.source "CustomerAttributeStore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "GetAttributeOptions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

.field public static final enum ForceRefresh:Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;


# instance fields
.field private final mUniqueValue:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 250
    new-instance v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    const-string/jumbo v1, "ForceRefresh"

    const-string/jumbo v2, "forceRefresh"

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;->ForceRefresh:Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    .line 244
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    const/4 v1, 0x0

    sget-object v2, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;->ForceRefresh:Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;->$VALUES:[Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p2, "uniqueValue"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 255
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 256
    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;->mUniqueValue:Ljava/lang/String;

    .line 257
    return-void
.end method

.method public static deserializeList(Lorg/json/JSONArray;)Ljava/util/EnumSet;
    .locals 5
    .param p0, "jsonOptions"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/EnumSet",
            "<",
            "Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;",
            ">;"
        }
    .end annotation

    .prologue
    .line 292
    const-class v3, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    invoke-static {v3}, Ljava/util/EnumSet;->noneOf(Ljava/lang/Class;)Ljava/util/EnumSet;

    move-result-object v2

    .line 293
    .local v2, "options":Ljava/util/EnumSet;, "Ljava/util/EnumSet<Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v1, v3, :cond_0

    .line 297
    :try_start_0
    invoke-virtual {p0, v1}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;->getOptionFromValue(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/EnumSet;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 293
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 299
    :catch_0
    move-exception v0

    .line 301
    .local v0, "e":Lorg/json/JSONException;
    # getter for: Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->access$000()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "Could not deseralize part of getAttribute options"

    invoke-static {v3, v4, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 305
    .end local v0    # "e":Lorg/json/JSONException;
    :cond_0
    return-object v2
.end method

.method public static getOptionFromValue(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;
    .locals 5
    .param p0, "value"    # Ljava/lang/String;

    .prologue
    .line 316
    invoke-static {}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;->values()[Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 318
    .local v3, "v":Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;
    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 324
    .end local v3    # "v":Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;
    :goto_1
    return-object v3

    .line 316
    .restart local v3    # "v":Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 324
    .end local v3    # "v":Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;
    :cond_1
    const/4 v3, 0x0

    goto :goto_1
.end method

.method public static serializeList(Ljava/util/EnumSet;)Lorg/json/JSONArray;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/EnumSet",
            "<",
            "Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;",
            ">;)",
            "Lorg/json/JSONArray;"
        }
    .end annotation

    .prologue
    .line 275
    .local p0, "options":Ljava/util/EnumSet;, "Ljava/util/EnumSet<Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;>;"
    new-instance v2, Lorg/json/JSONArray;

    invoke-direct {v2}, Lorg/json/JSONArray;-><init>()V

    .line 276
    .local v2, "seralizedOptions":Lorg/json/JSONArray;
    invoke-virtual {p0}, Ljava/util/EnumSet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    .line 278
    .local v1, "option":Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_0

    .line 281
    .end local v1    # "option":Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;
    :cond_0
    return-object v2
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 244
    const-class v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;
    .locals 1

    .prologue
    .line 244
    sget-object v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;->$VALUES:[Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    return-object v0
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 261
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;->mUniqueValue:Ljava/lang/String;

    return-object v0
.end method
