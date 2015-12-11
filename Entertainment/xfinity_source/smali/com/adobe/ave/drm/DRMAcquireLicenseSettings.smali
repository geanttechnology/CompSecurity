.class public final enum Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;
.super Ljava/lang/Enum;
.source "DRMAcquireLicenseSettings.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

.field public static final enum ALLOW_SERVER:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

.field public static final enum FORCE_REFRESH:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

.field public static final enum LOCAL_ONLY:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 28
    new-instance v0, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    const-string v1, "FORCE_REFRESH"

    invoke-direct {v0, v1, v2}, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;->FORCE_REFRESH:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    .line 32
    new-instance v0, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    const-string v1, "LOCAL_ONLY"

    invoke-direct {v0, v1, v3}, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;->LOCAL_ONLY:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    .line 36
    new-instance v0, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    const-string v1, "ALLOW_SERVER"

    invoke-direct {v0, v1, v4}, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;->ALLOW_SERVER:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    .line 24
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    sget-object v1, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;->FORCE_REFRESH:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    aput-object v1, v0, v2

    sget-object v1, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;->LOCAL_ONLY:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;->ALLOW_SERVER:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    aput-object v1, v0, v4

    sput-object v0, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;->$VALUES:[Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

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
    .line 24
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 24
    const-class v0, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    return-object v0
.end method

.method public static values()[Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;->$VALUES:[Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    invoke-virtual {v0}, [Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    return-object v0
.end method
