.class public final enum Lco/vine/android/util/SystemUtil$PrefBooleanState;
.super Ljava/lang/Enum;
.source "SystemUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/util/SystemUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "PrefBooleanState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lco/vine/android/util/SystemUtil$PrefBooleanState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lco/vine/android/util/SystemUtil$PrefBooleanState;

.field public static final enum FALSE:Lco/vine/android/util/SystemUtil$PrefBooleanState;

.field public static final enum TRUE:Lco/vine/android/util/SystemUtil$PrefBooleanState;

.field public static final enum UNKNOWN:Lco/vine/android/util/SystemUtil$PrefBooleanState;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 112
    new-instance v0, Lco/vine/android/util/SystemUtil$PrefBooleanState;

    const-string v1, "UNKNOWN"

    invoke-direct {v0, v1, v2}, Lco/vine/android/util/SystemUtil$PrefBooleanState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lco/vine/android/util/SystemUtil$PrefBooleanState;->UNKNOWN:Lco/vine/android/util/SystemUtil$PrefBooleanState;

    .line 113
    new-instance v0, Lco/vine/android/util/SystemUtil$PrefBooleanState;

    const-string v1, "TRUE"

    invoke-direct {v0, v1, v3}, Lco/vine/android/util/SystemUtil$PrefBooleanState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lco/vine/android/util/SystemUtil$PrefBooleanState;->TRUE:Lco/vine/android/util/SystemUtil$PrefBooleanState;

    .line 114
    new-instance v0, Lco/vine/android/util/SystemUtil$PrefBooleanState;

    const-string v1, "FALSE"

    invoke-direct {v0, v1, v4}, Lco/vine/android/util/SystemUtil$PrefBooleanState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lco/vine/android/util/SystemUtil$PrefBooleanState;->FALSE:Lco/vine/android/util/SystemUtil$PrefBooleanState;

    .line 111
    const/4 v0, 0x3

    new-array v0, v0, [Lco/vine/android/util/SystemUtil$PrefBooleanState;

    sget-object v1, Lco/vine/android/util/SystemUtil$PrefBooleanState;->UNKNOWN:Lco/vine/android/util/SystemUtil$PrefBooleanState;

    aput-object v1, v0, v2

    sget-object v1, Lco/vine/android/util/SystemUtil$PrefBooleanState;->TRUE:Lco/vine/android/util/SystemUtil$PrefBooleanState;

    aput-object v1, v0, v3

    sget-object v1, Lco/vine/android/util/SystemUtil$PrefBooleanState;->FALSE:Lco/vine/android/util/SystemUtil$PrefBooleanState;

    aput-object v1, v0, v4

    sput-object v0, Lco/vine/android/util/SystemUtil$PrefBooleanState;->$VALUES:[Lco/vine/android/util/SystemUtil$PrefBooleanState;

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
    .line 111
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lco/vine/android/util/SystemUtil$PrefBooleanState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 111
    const-class v0, Lco/vine/android/util/SystemUtil$PrefBooleanState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lco/vine/android/util/SystemUtil$PrefBooleanState;

    return-object v0
.end method

.method public static values()[Lco/vine/android/util/SystemUtil$PrefBooleanState;
    .locals 1

    .prologue
    .line 111
    sget-object v0, Lco/vine/android/util/SystemUtil$PrefBooleanState;->$VALUES:[Lco/vine/android/util/SystemUtil$PrefBooleanState;

    invoke-virtual {v0}, [Lco/vine/android/util/SystemUtil$PrefBooleanState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lco/vine/android/util/SystemUtil$PrefBooleanState;

    return-object v0
.end method
