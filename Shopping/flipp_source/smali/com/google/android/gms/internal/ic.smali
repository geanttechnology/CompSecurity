.class public final Lcom/google/android/gms/internal/ic;
.super Lcom/google/android/gms/drive/metadata/internal/f;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/drive/metadata/internal/f",
        "<",
        "Lcom/google/android/gms/drive/DriveId;",
        ">;"
    }
.end annotation


# static fields
.field public static final b:Lcom/google/android/gms/internal/ic;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/google/android/gms/internal/ic;

    invoke-direct {v0}, Lcom/google/android/gms/internal/ic;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/ic;->b:Lcom/google/android/gms/internal/ic;

    return-void
.end method

.method private constructor <init>()V
    .locals 4

    const-string v0, "driveId"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "sqlId"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "resourceId"

    aput-object v3, v1, v2

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/google/android/gms/drive/metadata/internal/f;-><init>(Ljava/lang/String;Ljava/util/Collection;)V

    return-void
.end method
