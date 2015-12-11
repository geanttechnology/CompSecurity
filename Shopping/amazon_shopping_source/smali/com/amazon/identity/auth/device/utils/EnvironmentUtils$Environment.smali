.class public final enum Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;
.super Ljava/lang/Enum;
.source "EnvironmentUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401c
    name = "Environment"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

.field public static final enum devo:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

.field public static final enum pre_prod:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

.field public static final enum prod:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 22
    new-instance v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    const-string/jumbo v1, "devo"

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->devo:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    .line 23
    new-instance v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    const-string/jumbo v1, "pre_prod"

    invoke-direct {v0, v1, v3}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->pre_prod:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    .line 24
    new-instance v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    const-string/jumbo v1, "prod"

    invoke-direct {v0, v1, v4}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->prod:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    .line 20
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    sget-object v1, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->devo:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->pre_prod:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->prod:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->$VALUES:[Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 20
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static fromString(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;
    .locals 8
    .param p0, "value"    # Ljava/lang/String;

    .prologue
    .line 28
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->values()[Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_1

    aget-object v1, v0, v2

    .line 30
    .local v1, "env":Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 38
    .end local v1    # "env":Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;
    :goto_1
    return-object v1

    .line 28
    .restart local v1    # "env":Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 37
    .end local v1    # "env":Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;
    :cond_1
    # getter for: Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->access$000()Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "Not able to determine environment for value %s. Defaulting to Prod"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p0, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 38
    sget-object v1, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->prod:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 20
    const-class v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;
    .locals 1

    .prologue
    .line 20
    sget-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->$VALUES:[Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    return-object v0
.end method
