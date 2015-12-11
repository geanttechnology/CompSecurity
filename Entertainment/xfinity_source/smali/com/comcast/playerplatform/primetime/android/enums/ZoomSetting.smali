.class public final enum Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;
.super Ljava/lang/Enum;
.source "ZoomSetting.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

.field public static final enum Full:Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

.field public static final enum None:Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 15
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    const-string v1, "None"

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;->None:Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    .line 19
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    const-string v1, "Full"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;->Full:Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    .line 11
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;->None:Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;->Full:Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    aput-object v1, v0, v3

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

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
    .line 11
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    return-object v0
.end method
