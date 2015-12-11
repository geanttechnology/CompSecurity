.class public enum Lcom/adobe/ave/drm/DRMAuthenticationMethod;
.super Ljava/lang/Enum;
.source "DRMAuthenticationMethod.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/ave/drm/DRMAuthenticationMethod;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/ave/drm/DRMAuthenticationMethod;

.field public static final enum ANONYMOUS:Lcom/adobe/ave/drm/DRMAuthenticationMethod;

.field public static final enum UNKNOWN:Lcom/adobe/ave/drm/DRMAuthenticationMethod;

.field public static final enum USERNAME_AND_PASSWORD:Lcom/adobe/ave/drm/DRMAuthenticationMethod;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 27
    new-instance v0, Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    const-string v1, "UNKNOWN"

    invoke-direct {v0, v1, v2}, Lcom/adobe/ave/drm/DRMAuthenticationMethod;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/ave/drm/DRMAuthenticationMethod;->UNKNOWN:Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    new-instance v0, Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    const-string v1, "ANONYMOUS"

    invoke-direct {v0, v1, v3}, Lcom/adobe/ave/drm/DRMAuthenticationMethod;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/ave/drm/DRMAuthenticationMethod;->ANONYMOUS:Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    .line 28
    new-instance v0, Lcom/adobe/ave/drm/DRMAuthenticationMethod$1;

    const-string v1, "USERNAME_AND_PASSWORD"

    invoke-direct {v0, v1, v4}, Lcom/adobe/ave/drm/DRMAuthenticationMethod$1;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/ave/drm/DRMAuthenticationMethod;->USERNAME_AND_PASSWORD:Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    .line 25
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    sget-object v1, Lcom/adobe/ave/drm/DRMAuthenticationMethod;->UNKNOWN:Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    aput-object v1, v0, v2

    sget-object v1, Lcom/adobe/ave/drm/DRMAuthenticationMethod;->ANONYMOUS:Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/ave/drm/DRMAuthenticationMethod;->USERNAME_AND_PASSWORD:Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    aput-object v1, v0, v4

    sput-object v0, Lcom/adobe/ave/drm/DRMAuthenticationMethod;->$VALUES:[Lcom/adobe/ave/drm/DRMAuthenticationMethod;

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
    .line 25
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;ILcom/adobe/ave/drm/DRMAuthenticationMethod$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # I
    .param p3, "x2"    # Lcom/adobe/ave/drm/DRMAuthenticationMethod$1;

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lcom/adobe/ave/drm/DRMAuthenticationMethod;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/ave/drm/DRMAuthenticationMethod;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 25
    const-class v0, Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    return-object v0
.end method

.method public static values()[Lcom/adobe/ave/drm/DRMAuthenticationMethod;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lcom/adobe/ave/drm/DRMAuthenticationMethod;->$VALUES:[Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    invoke-virtual {v0}, [Lcom/adobe/ave/drm/DRMAuthenticationMethod;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    return-object v0
.end method
