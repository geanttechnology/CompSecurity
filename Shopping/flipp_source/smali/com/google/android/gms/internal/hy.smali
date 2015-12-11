.class public final Lcom/google/android/gms/internal/hy;
.super Ljava/lang/Object;


# static fields
.field public static final a:Lcom/google/android/gms/drive/metadata/b;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/drive/metadata/b",
            "<",
            "Lcom/google/android/gms/drive/DriveId;",
            ">;"
        }
    .end annotation
.end field

.field public static final b:Lcom/google/android/gms/drive/metadata/b;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/drive/metadata/b",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static final c:Lcom/google/android/gms/drive/metadata/b;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/drive/metadata/b",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static final d:Lcom/google/android/gms/drive/metadata/b;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/drive/metadata/b",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field public static final e:Lcom/google/android/gms/drive/metadata/b;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/drive/metadata/b",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field public static final f:Lcom/google/android/gms/drive/metadata/b;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/drive/metadata/b",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field public static final g:Lcom/google/android/gms/drive/metadata/b;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/drive/metadata/b",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field public static final h:Lcom/google/android/gms/drive/metadata/a;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/drive/metadata/a",
            "<",
            "Lcom/google/android/gms/drive/DriveId;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    sget-object v0, Lcom/google/android/gms/internal/ic;->b:Lcom/google/android/gms/internal/ic;

    sput-object v0, Lcom/google/android/gms/internal/hy;->a:Lcom/google/android/gms/drive/metadata/b;

    new-instance v0, Lcom/google/android/gms/drive/metadata/d;

    const-string v1, "title"

    invoke-direct {v0, v1}, Lcom/google/android/gms/drive/metadata/d;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/hy;->b:Lcom/google/android/gms/drive/metadata/b;

    new-instance v0, Lcom/google/android/gms/drive/metadata/d;

    const-string v1, "mimeType"

    invoke-direct {v0, v1}, Lcom/google/android/gms/drive/metadata/d;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/hy;->c:Lcom/google/android/gms/drive/metadata/b;

    new-instance v0, Lcom/google/android/gms/drive/metadata/internal/a;

    const-string v1, "starred"

    invoke-direct {v0, v1}, Lcom/google/android/gms/drive/metadata/internal/a;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/hy;->d:Lcom/google/android/gms/drive/metadata/b;

    new-instance v0, Lcom/google/android/gms/internal/hz;

    const-string v1, "trashed"

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/hz;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/hy;->e:Lcom/google/android/gms/drive/metadata/b;

    new-instance v0, Lcom/google/android/gms/drive/metadata/internal/a;

    const-string v1, "isEditable"

    invoke-direct {v0, v1}, Lcom/google/android/gms/drive/metadata/internal/a;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/hy;->f:Lcom/google/android/gms/drive/metadata/b;

    new-instance v0, Lcom/google/android/gms/drive/metadata/internal/a;

    const-string v1, "isPinned"

    invoke-direct {v0, v1}, Lcom/google/android/gms/drive/metadata/internal/a;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/hy;->g:Lcom/google/android/gms/drive/metadata/b;

    new-instance v0, Lcom/google/android/gms/drive/metadata/internal/e;

    const-string v1, "parents"

    invoke-direct {v0, v1}, Lcom/google/android/gms/drive/metadata/internal/e;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/hy;->h:Lcom/google/android/gms/drive/metadata/a;

    return-void
.end method
