.class public final Lcom/google/android/gms/internal/bm;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;


# static fields
.field public static final CREATOR:Lcom/google/android/gms/internal/ch;


# instance fields
.field public final a:I

.field public final b:Lcom/google/android/gms/internal/bj;

.field public final c:Lcom/google/android/gms/internal/kq;

.field public final d:Lcom/google/android/gms/internal/ci;

.field public final e:Lcom/google/android/gms/internal/ew;

.field public final f:Lcom/google/android/gms/internal/u;

.field public final g:Ljava/lang/String;

.field public final h:Z

.field public final i:Ljava/lang/String;

.field public final j:Lcom/google/android/gms/internal/cn;

.field public final k:I

.field public final l:I

.field public final m:Ljava/lang/String;

.field public final n:Lcom/google/android/gms/internal/cu;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/google/android/gms/internal/ch;

    invoke-direct {v0}, Lcom/google/android/gms/internal/ch;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/bm;->CREATOR:Lcom/google/android/gms/internal/ch;

    return-void
.end method

.method constructor <init>(ILcom/google/android/gms/internal/bj;Landroid/os/IBinder;Landroid/os/IBinder;Landroid/os/IBinder;Landroid/os/IBinder;Ljava/lang/String;ZLjava/lang/String;Landroid/os/IBinder;IILjava/lang/String;Lcom/google/android/gms/internal/cu;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/google/android/gms/internal/bm;->a:I

    iput-object p2, p0, Lcom/google/android/gms/internal/bm;->b:Lcom/google/android/gms/internal/bj;

    invoke-static {p3}, Lcom/google/android/gms/a/b;->a(Landroid/os/IBinder;)Lcom/google/android/gms/a/a;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/a/d;->a(Lcom/google/android/gms/a/a;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/kq;

    iput-object v0, p0, Lcom/google/android/gms/internal/bm;->c:Lcom/google/android/gms/internal/kq;

    invoke-static {p4}, Lcom/google/android/gms/a/b;->a(Landroid/os/IBinder;)Lcom/google/android/gms/a/a;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/a/d;->a(Lcom/google/android/gms/a/a;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/ci;

    iput-object v0, p0, Lcom/google/android/gms/internal/bm;->d:Lcom/google/android/gms/internal/ci;

    invoke-static {p5}, Lcom/google/android/gms/a/b;->a(Landroid/os/IBinder;)Lcom/google/android/gms/a/a;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/a/d;->a(Lcom/google/android/gms/a/a;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/ew;

    iput-object v0, p0, Lcom/google/android/gms/internal/bm;->e:Lcom/google/android/gms/internal/ew;

    invoke-static {p6}, Lcom/google/android/gms/a/b;->a(Landroid/os/IBinder;)Lcom/google/android/gms/a/a;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/a/d;->a(Lcom/google/android/gms/a/a;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/u;

    iput-object v0, p0, Lcom/google/android/gms/internal/bm;->f:Lcom/google/android/gms/internal/u;

    iput-object p7, p0, Lcom/google/android/gms/internal/bm;->g:Ljava/lang/String;

    iput-boolean p8, p0, Lcom/google/android/gms/internal/bm;->h:Z

    iput-object p9, p0, Lcom/google/android/gms/internal/bm;->i:Ljava/lang/String;

    invoke-static {p10}, Lcom/google/android/gms/a/b;->a(Landroid/os/IBinder;)Lcom/google/android/gms/a/a;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/a/d;->a(Lcom/google/android/gms/a/a;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/cn;

    iput-object v0, p0, Lcom/google/android/gms/internal/bm;->j:Lcom/google/android/gms/internal/cn;

    iput p11, p0, Lcom/google/android/gms/internal/bm;->k:I

    iput p12, p0, Lcom/google/android/gms/internal/bm;->l:I

    iput-object p13, p0, Lcom/google/android/gms/internal/bm;->m:Ljava/lang/String;

    iput-object p14, p0, Lcom/google/android/gms/internal/bm;->n:Lcom/google/android/gms/internal/cu;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/internal/bj;Lcom/google/android/gms/internal/kq;Lcom/google/android/gms/internal/ci;Lcom/google/android/gms/internal/cn;Lcom/google/android/gms/internal/cu;)V
    .locals 2

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    iput v0, p0, Lcom/google/android/gms/internal/bm;->a:I

    iput-object p1, p0, Lcom/google/android/gms/internal/bm;->b:Lcom/google/android/gms/internal/bj;

    iput-object p2, p0, Lcom/google/android/gms/internal/bm;->c:Lcom/google/android/gms/internal/kq;

    iput-object p3, p0, Lcom/google/android/gms/internal/bm;->d:Lcom/google/android/gms/internal/ci;

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->e:Lcom/google/android/gms/internal/ew;

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->f:Lcom/google/android/gms/internal/u;

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->g:Ljava/lang/String;

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gms/internal/bm;->h:Z

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->i:Ljava/lang/String;

    iput-object p4, p0, Lcom/google/android/gms/internal/bm;->j:Lcom/google/android/gms/internal/cn;

    const/4 v0, -0x1

    iput v0, p0, Lcom/google/android/gms/internal/bm;->k:I

    const/4 v0, 0x4

    iput v0, p0, Lcom/google/android/gms/internal/bm;->l:I

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->m:Ljava/lang/String;

    iput-object p5, p0, Lcom/google/android/gms/internal/bm;->n:Lcom/google/android/gms/internal/cu;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/internal/kq;Lcom/google/android/gms/internal/ci;Lcom/google/android/gms/internal/cn;Lcom/google/android/gms/internal/ew;ILcom/google/android/gms/internal/cu;)V
    .locals 3

    const/4 v2, 0x1

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput v2, p0, Lcom/google/android/gms/internal/bm;->a:I

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->b:Lcom/google/android/gms/internal/bj;

    iput-object p1, p0, Lcom/google/android/gms/internal/bm;->c:Lcom/google/android/gms/internal/kq;

    iput-object p2, p0, Lcom/google/android/gms/internal/bm;->d:Lcom/google/android/gms/internal/ci;

    iput-object p4, p0, Lcom/google/android/gms/internal/bm;->e:Lcom/google/android/gms/internal/ew;

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->f:Lcom/google/android/gms/internal/u;

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->g:Ljava/lang/String;

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gms/internal/bm;->h:Z

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->i:Ljava/lang/String;

    iput-object p3, p0, Lcom/google/android/gms/internal/bm;->j:Lcom/google/android/gms/internal/cn;

    iput p5, p0, Lcom/google/android/gms/internal/bm;->k:I

    iput v2, p0, Lcom/google/android/gms/internal/bm;->l:I

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->m:Ljava/lang/String;

    iput-object p6, p0, Lcom/google/android/gms/internal/bm;->n:Lcom/google/android/gms/internal/cu;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/internal/kq;Lcom/google/android/gms/internal/ci;Lcom/google/android/gms/internal/cn;Lcom/google/android/gms/internal/ew;ZILcom/google/android/gms/internal/cu;)V
    .locals 2

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    iput v0, p0, Lcom/google/android/gms/internal/bm;->a:I

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->b:Lcom/google/android/gms/internal/bj;

    iput-object p1, p0, Lcom/google/android/gms/internal/bm;->c:Lcom/google/android/gms/internal/kq;

    iput-object p2, p0, Lcom/google/android/gms/internal/bm;->d:Lcom/google/android/gms/internal/ci;

    iput-object p4, p0, Lcom/google/android/gms/internal/bm;->e:Lcom/google/android/gms/internal/ew;

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->f:Lcom/google/android/gms/internal/u;

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->g:Ljava/lang/String;

    iput-boolean p5, p0, Lcom/google/android/gms/internal/bm;->h:Z

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->i:Ljava/lang/String;

    iput-object p3, p0, Lcom/google/android/gms/internal/bm;->j:Lcom/google/android/gms/internal/cn;

    iput p6, p0, Lcom/google/android/gms/internal/bm;->k:I

    const/4 v0, 0x2

    iput v0, p0, Lcom/google/android/gms/internal/bm;->l:I

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->m:Ljava/lang/String;

    iput-object p7, p0, Lcom/google/android/gms/internal/bm;->n:Lcom/google/android/gms/internal/cu;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/internal/kq;Lcom/google/android/gms/internal/ci;Lcom/google/android/gms/internal/u;Lcom/google/android/gms/internal/cn;Lcom/google/android/gms/internal/ew;ZILjava/lang/String;Lcom/google/android/gms/internal/cu;)V
    .locals 2

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    iput v0, p0, Lcom/google/android/gms/internal/bm;->a:I

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->b:Lcom/google/android/gms/internal/bj;

    iput-object p1, p0, Lcom/google/android/gms/internal/bm;->c:Lcom/google/android/gms/internal/kq;

    iput-object p2, p0, Lcom/google/android/gms/internal/bm;->d:Lcom/google/android/gms/internal/ci;

    iput-object p5, p0, Lcom/google/android/gms/internal/bm;->e:Lcom/google/android/gms/internal/ew;

    iput-object p3, p0, Lcom/google/android/gms/internal/bm;->f:Lcom/google/android/gms/internal/u;

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->g:Ljava/lang/String;

    iput-boolean p6, p0, Lcom/google/android/gms/internal/bm;->h:Z

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->i:Ljava/lang/String;

    iput-object p4, p0, Lcom/google/android/gms/internal/bm;->j:Lcom/google/android/gms/internal/cn;

    iput p7, p0, Lcom/google/android/gms/internal/bm;->k:I

    const/4 v0, 0x3

    iput v0, p0, Lcom/google/android/gms/internal/bm;->l:I

    iput-object p8, p0, Lcom/google/android/gms/internal/bm;->m:Ljava/lang/String;

    iput-object p9, p0, Lcom/google/android/gms/internal/bm;->n:Lcom/google/android/gms/internal/cu;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/internal/kq;Lcom/google/android/gms/internal/ci;Lcom/google/android/gms/internal/u;Lcom/google/android/gms/internal/cn;Lcom/google/android/gms/internal/ew;ZILjava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/cu;)V
    .locals 2

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    iput v0, p0, Lcom/google/android/gms/internal/bm;->a:I

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->b:Lcom/google/android/gms/internal/bj;

    iput-object p1, p0, Lcom/google/android/gms/internal/bm;->c:Lcom/google/android/gms/internal/kq;

    iput-object p2, p0, Lcom/google/android/gms/internal/bm;->d:Lcom/google/android/gms/internal/ci;

    iput-object p5, p0, Lcom/google/android/gms/internal/bm;->e:Lcom/google/android/gms/internal/ew;

    iput-object p3, p0, Lcom/google/android/gms/internal/bm;->f:Lcom/google/android/gms/internal/u;

    iput-object p9, p0, Lcom/google/android/gms/internal/bm;->g:Ljava/lang/String;

    iput-boolean p6, p0, Lcom/google/android/gms/internal/bm;->h:Z

    iput-object p8, p0, Lcom/google/android/gms/internal/bm;->i:Ljava/lang/String;

    iput-object p4, p0, Lcom/google/android/gms/internal/bm;->j:Lcom/google/android/gms/internal/cn;

    iput p7, p0, Lcom/google/android/gms/internal/bm;->k:I

    const/4 v0, 0x3

    iput v0, p0, Lcom/google/android/gms/internal/bm;->l:I

    iput-object v1, p0, Lcom/google/android/gms/internal/bm;->m:Ljava/lang/String;

    iput-object p10, p0, Lcom/google/android/gms/internal/bm;->n:Lcom/google/android/gms/internal/cu;

    return-void
.end method

.method public static a(Landroid/content/Intent;)Lcom/google/android/gms/internal/bm;
    .locals 2

    :try_start_0
    const-string v0, "com.google.android.gms.ads.inernal.overlay.AdOverlayInfo"

    invoke-virtual {p0, v0}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/google/android/gms/internal/bm;

    invoke-virtual {v1}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->setClassLoader(Ljava/lang/ClassLoader;)V

    const-string v1, "com.google.android.gms.ads.inernal.overlay.AdOverlayInfo"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/bm;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static a(Landroid/content/Intent;Lcom/google/android/gms/internal/bm;)V
    .locals 2

    new-instance v0, Landroid/os/Bundle;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroid/os/Bundle;-><init>(I)V

    const-string v1, "com.google.android.gms.ads.inernal.overlay.AdOverlayInfo"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    const-string v1, "com.google.android.gms.ads.inernal.overlay.AdOverlayInfo"

    invoke-virtual {p0, v1, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    return-void
.end method


# virtual methods
.method public final describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public final writeToParcel(Landroid/os/Parcel;I)V
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/ch;->a(Lcom/google/android/gms/internal/bm;Landroid/os/Parcel;I)V

    return-void
.end method
