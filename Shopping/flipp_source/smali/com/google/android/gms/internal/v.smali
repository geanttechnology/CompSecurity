.class public final Lcom/google/android/gms/internal/v;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;


# static fields
.field public static final CREATOR:Lcom/google/android/gms/internal/kx;


# instance fields
.field public final a:I

.field public final b:J

.field public final c:Landroid/os/Bundle;

.field public final d:I

.field public final e:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public final f:Z

.field public final g:I

.field public final h:Z

.field public final i:Ljava/lang/String;

.field public final j:Lcom/google/android/gms/internal/ai;

.field public final k:Landroid/location/Location;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/google/android/gms/internal/kx;

    invoke-direct {v0}, Lcom/google/android/gms/internal/kx;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/v;->CREATOR:Lcom/google/android/gms/internal/kx;

    return-void
.end method

.method constructor <init>(IJLandroid/os/Bundle;ILjava/util/List;ZIZLjava/lang/String;Lcom/google/android/gms/internal/ai;Landroid/location/Location;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(IJ",
            "Landroid/os/Bundle;",
            "I",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;ZIZ",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/internal/ai;",
            "Landroid/location/Location;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/google/android/gms/internal/v;->a:I

    iput-wide p2, p0, Lcom/google/android/gms/internal/v;->b:J

    iput-object p4, p0, Lcom/google/android/gms/internal/v;->c:Landroid/os/Bundle;

    iput p5, p0, Lcom/google/android/gms/internal/v;->d:I

    iput-object p6, p0, Lcom/google/android/gms/internal/v;->e:Ljava/util/List;

    iput-boolean p7, p0, Lcom/google/android/gms/internal/v;->f:Z

    iput p8, p0, Lcom/google/android/gms/internal/v;->g:I

    iput-boolean p9, p0, Lcom/google/android/gms/internal/v;->h:Z

    iput-object p10, p0, Lcom/google/android/gms/internal/v;->i:Ljava/lang/String;

    iput-object p11, p0, Lcom/google/android/gms/internal/v;->j:Lcom/google/android/gms/internal/ai;

    iput-object p12, p0, Lcom/google/android/gms/internal/v;->k:Landroid/location/Location;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/internal/o;)V
    .locals 3

    const/4 v2, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x2

    iput v0, p0, Lcom/google/android/gms/internal/v;->a:I

    iget-object v0, p2, Lcom/google/android/gms/internal/o;->b:Ljava/util/Date;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    :goto_0
    iput-wide v0, p0, Lcom/google/android/gms/internal/v;->b:J

    iget v0, p2, Lcom/google/android/gms/internal/o;->c:I

    iput v0, p0, Lcom/google/android/gms/internal/v;->d:I

    iget-object v0, p2, Lcom/google/android/gms/internal/o;->d:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_2

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    invoke-static {v1}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    :goto_1
    iput-object v0, p0, Lcom/google/android/gms/internal/v;->e:Ljava/util/List;

    invoke-virtual {p2, p1}, Lcom/google/android/gms/internal/o;->a(Landroid/content/Context;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/google/android/gms/internal/v;->f:Z

    iget v0, p2, Lcom/google/android/gms/internal/o;->j:I

    iput v0, p0, Lcom/google/android/gms/internal/v;->g:I

    iget-object v0, p2, Lcom/google/android/gms/internal/o;->e:Landroid/location/Location;

    iput-object v0, p0, Lcom/google/android/gms/internal/v;->k:Landroid/location/Location;

    const-class v0, Lcom/google/android/gms/ads/mediation/admob/AdMobExtras;

    invoke-virtual {p2, v0}, Lcom/google/android/gms/internal/o;->a(Ljava/lang/Class;)Lcom/google/android/gms/ads/mediation/NetworkExtras;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/ads/mediation/admob/AdMobExtras;

    if-eqz v0, :cond_3

    invoke-virtual {v0}, Lcom/google/android/gms/ads/mediation/admob/AdMobExtras;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    :goto_2
    iput-object v0, p0, Lcom/google/android/gms/internal/v;->c:Landroid/os/Bundle;

    iget-boolean v0, p2, Lcom/google/android/gms/internal/o;->f:Z

    iput-boolean v0, p0, Lcom/google/android/gms/internal/v;->h:Z

    iget-object v0, p2, Lcom/google/android/gms/internal/o;->h:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/v;->i:Ljava/lang/String;

    iget-object v0, p2, Lcom/google/android/gms/internal/o;->i:Lcom/google/android/gms/ads/search/SearchAdRequest;

    if-eqz v0, :cond_0

    new-instance v2, Lcom/google/android/gms/internal/ai;

    invoke-direct {v2, v0}, Lcom/google/android/gms/internal/ai;-><init>(Lcom/google/android/gms/ads/search/SearchAdRequest;)V

    :cond_0
    iput-object v2, p0, Lcom/google/android/gms/internal/v;->j:Lcom/google/android/gms/internal/ai;

    return-void

    :cond_1
    const-wide/16 v0, -0x1

    goto :goto_0

    :cond_2
    move-object v0, v2

    goto :goto_1

    :cond_3
    move-object v0, v2

    goto :goto_2
.end method


# virtual methods
.method public final describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public final writeToParcel(Landroid/os/Parcel;I)V
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/kx;->a(Lcom/google/android/gms/internal/v;Landroid/os/Parcel;I)V

    return-void
.end method
