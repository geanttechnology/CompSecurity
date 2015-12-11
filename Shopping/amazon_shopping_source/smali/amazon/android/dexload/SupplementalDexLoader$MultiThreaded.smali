.class public final enum Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;
.super Ljava/lang/Enum;
.source "SupplementalDexLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lamazon/android/dexload/SupplementalDexLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "MultiThreaded"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;

.field public static final enum NO:Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;

.field public static final enum YES:Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 73
    new-instance v0, Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;

    const-string/jumbo v1, "YES"

    invoke-direct {v0, v1, v2}, Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;->YES:Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;

    .line 74
    new-instance v0, Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;

    const-string/jumbo v1, "NO"

    invoke-direct {v0, v1, v3}, Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;->NO:Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;

    .line 72
    const/4 v0, 0x2

    new-array v0, v0, [Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;

    sget-object v1, Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;->YES:Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;

    aput-object v1, v0, v2

    sget-object v1, Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;->NO:Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;

    aput-object v1, v0, v3

    sput-object v0, Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;->$VALUES:[Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;

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
    .line 72
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 72
    const-class v0, Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;

    return-object v0
.end method

.method public static values()[Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;
    .locals 1

    .prologue
    .line 72
    sget-object v0, Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;->$VALUES:[Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;

    invoke-virtual {v0}, [Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;

    return-object v0
.end method
