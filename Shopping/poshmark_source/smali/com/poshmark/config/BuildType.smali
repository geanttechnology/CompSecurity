.class public final enum Lcom/poshmark/config/BuildType;
.super Ljava/lang/Enum;
.source "BuildType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/config/BuildType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/config/BuildType;

.field public static final enum DEBUG:Lcom/poshmark/config/BuildType;

.field public static final enum RELEASE:Lcom/poshmark/config/BuildType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 10
    new-instance v0, Lcom/poshmark/config/BuildType;

    const-string v1, "DEBUG"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/config/BuildType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/config/BuildType;->DEBUG:Lcom/poshmark/config/BuildType;

    .line 11
    new-instance v0, Lcom/poshmark/config/BuildType;

    const-string v1, "RELEASE"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/config/BuildType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/config/BuildType;->RELEASE:Lcom/poshmark/config/BuildType;

    .line 8
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/poshmark/config/BuildType;

    sget-object v1, Lcom/poshmark/config/BuildType;->DEBUG:Lcom/poshmark/config/BuildType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/config/BuildType;->RELEASE:Lcom/poshmark/config/BuildType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/poshmark/config/BuildType;->$VALUES:[Lcom/poshmark/config/BuildType;

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
    .line 8
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/config/BuildType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 8
    const-class v0, Lcom/poshmark/config/BuildType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/config/BuildType;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/config/BuildType;
    .locals 1

    .prologue
    .line 8
    sget-object v0, Lcom/poshmark/config/BuildType;->$VALUES:[Lcom/poshmark/config/BuildType;

    invoke-virtual {v0}, [Lcom/poshmark/config/BuildType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/config/BuildType;

    return-object v0
.end method
