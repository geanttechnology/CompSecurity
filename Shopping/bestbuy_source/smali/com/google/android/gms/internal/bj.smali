.class public final Lcom/google/android/gms/internal/bj;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;


# annotations
.annotation runtime Lzf;
.end annotation


# static fields
.field public static final CREATOR:Lud;


# instance fields
.field public final a:I

.field public final b:I

.field public final c:I

.field public final d:I

.field public final e:I

.field public final f:I

.field public final g:I

.field public final h:I

.field public final i:I

.field public final j:Ljava/lang/String;

.field public final k:I

.field public final l:Ljava/lang/String;

.field public final m:I

.field public final n:I

.field public final o:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lud;

    invoke-direct {v0}, Lud;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/bj;->CREATOR:Lud;

    return-void
.end method

.method public constructor <init>(IIIIIIIIILjava/lang/String;ILjava/lang/String;IILjava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/google/android/gms/internal/bj;->a:I

    iput p2, p0, Lcom/google/android/gms/internal/bj;->b:I

    iput p3, p0, Lcom/google/android/gms/internal/bj;->c:I

    iput p4, p0, Lcom/google/android/gms/internal/bj;->d:I

    iput p5, p0, Lcom/google/android/gms/internal/bj;->e:I

    iput p6, p0, Lcom/google/android/gms/internal/bj;->f:I

    iput p7, p0, Lcom/google/android/gms/internal/bj;->g:I

    iput p8, p0, Lcom/google/android/gms/internal/bj;->h:I

    iput p9, p0, Lcom/google/android/gms/internal/bj;->i:I

    iput-object p10, p0, Lcom/google/android/gms/internal/bj;->j:Ljava/lang/String;

    iput p11, p0, Lcom/google/android/gms/internal/bj;->k:I

    iput-object p12, p0, Lcom/google/android/gms/internal/bj;->l:Ljava/lang/String;

    iput p13, p0, Lcom/google/android/gms/internal/bj;->m:I

    iput p14, p0, Lcom/google/android/gms/internal/bj;->n:I

    iput-object p15, p0, Lcom/google/android/gms/internal/bj;->o:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lpj;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    iput v0, p0, Lcom/google/android/gms/internal/bj;->a:I

    invoke-virtual {p1}, Lpj;->a()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/bj;->b:I

    invoke-virtual {p1}, Lpj;->b()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/bj;->c:I

    invoke-virtual {p1}, Lpj;->c()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/bj;->d:I

    invoke-virtual {p1}, Lpj;->d()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/bj;->e:I

    invoke-virtual {p1}, Lpj;->e()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/bj;->f:I

    invoke-virtual {p1}, Lpj;->f()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/bj;->g:I

    invoke-virtual {p1}, Lpj;->g()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/bj;->h:I

    invoke-virtual {p1}, Lpj;->h()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/bj;->i:I

    invoke-virtual {p1}, Lpj;->i()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/bj;->j:Ljava/lang/String;

    invoke-virtual {p1}, Lpj;->j()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/bj;->k:I

    invoke-virtual {p1}, Lpj;->k()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/bj;->l:Ljava/lang/String;

    invoke-virtual {p1}, Lpj;->l()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/bj;->m:I

    invoke-virtual {p1}, Lpj;->m()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/bj;->n:I

    invoke-virtual {p1}, Lpj;->n()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/bj;->o:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 0

    invoke-static {p0, p1, p2}, Lud;->a(Lcom/google/android/gms/internal/bj;Landroid/os/Parcel;I)V

    return-void
.end method
