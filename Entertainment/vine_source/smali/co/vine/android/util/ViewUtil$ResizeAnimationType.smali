.class public final enum Lco/vine/android/util/ViewUtil$ResizeAnimationType;
.super Ljava/lang/Enum;
.source "ViewUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/util/ViewUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ResizeAnimationType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lco/vine/android/util/ViewUtil$ResizeAnimationType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lco/vine/android/util/ViewUtil$ResizeAnimationType;

.field public static final enum COLLAPSE_HEIGHT:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

.field public static final enum COLLAPSE_WIDTH:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

.field public static final enum EXPAND_HEIGHT:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

.field public static final enum EXPAND_WIDTH:Lco/vine/android/util/ViewUtil$ResizeAnimationType;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 150
    new-instance v0, Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    const-string v1, "EXPAND_WIDTH"

    invoke-direct {v0, v1, v2}, Lco/vine/android/util/ViewUtil$ResizeAnimationType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->EXPAND_WIDTH:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    .line 151
    new-instance v0, Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    const-string v1, "EXPAND_HEIGHT"

    invoke-direct {v0, v1, v3}, Lco/vine/android/util/ViewUtil$ResizeAnimationType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->EXPAND_HEIGHT:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    .line 152
    new-instance v0, Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    const-string v1, "COLLAPSE_WIDTH"

    invoke-direct {v0, v1, v4}, Lco/vine/android/util/ViewUtil$ResizeAnimationType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->COLLAPSE_WIDTH:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    .line 153
    new-instance v0, Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    const-string v1, "COLLAPSE_HEIGHT"

    invoke-direct {v0, v1, v5}, Lco/vine/android/util/ViewUtil$ResizeAnimationType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->COLLAPSE_HEIGHT:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    .line 149
    const/4 v0, 0x4

    new-array v0, v0, [Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    sget-object v1, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->EXPAND_WIDTH:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    aput-object v1, v0, v2

    sget-object v1, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->EXPAND_HEIGHT:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    aput-object v1, v0, v3

    sget-object v1, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->COLLAPSE_WIDTH:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    aput-object v1, v0, v4

    sget-object v1, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->COLLAPSE_HEIGHT:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    aput-object v1, v0, v5

    sput-object v0, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->$VALUES:[Lco/vine/android/util/ViewUtil$ResizeAnimationType;

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
    .line 149
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lco/vine/android/util/ViewUtil$ResizeAnimationType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 149
    const-class v0, Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    return-object v0
.end method

.method public static values()[Lco/vine/android/util/ViewUtil$ResizeAnimationType;
    .locals 1

    .prologue
    .line 149
    sget-object v0, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->$VALUES:[Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    invoke-virtual {v0}, [Lco/vine/android/util/ViewUtil$ResizeAnimationType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    return-object v0
.end method
