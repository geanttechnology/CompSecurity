.class public final Lcom/google/android/gms/internal/hd;
.super Lcom/google/android/gms/internal/iy;

# interfaces
.implements Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;


# static fields
.field public static final CREATOR:Lcom/google/android/gms/internal/jk;


# instance fields
.field final a:I

.field final b:Ljava/lang/String;

.field final c:Landroid/os/Bundle;

.field final d:Lcom/google/android/gms/internal/hf;

.field final e:Lcom/google/android/gms/maps/model/LatLng;

.field final f:F

.field final g:Lcom/google/android/gms/maps/model/LatLngBounds;

.field final h:Ljava/lang/String;

.field final i:Landroid/net/Uri;

.field final j:Z

.field final k:F

.field final l:I

.field final m:J

.field final n:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gms/internal/gx;",
            ">;"
        }
    .end annotation
.end field

.field private final o:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/google/android/gms/internal/gx;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final p:Ljava/util/TimeZone;

.field private q:Ljava/util/Locale;

.field private r:Lcom/google/android/gms/internal/jm;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/google/android/gms/internal/jk;

    invoke-direct {v0}, Lcom/google/android/gms/internal/jk;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/hd;->CREATOR:Lcom/google/android/gms/internal/jk;

    return-void
.end method

.method constructor <init>(ILjava/lang/String;Ljava/util/List;Landroid/os/Bundle;Lcom/google/android/gms/internal/hf;Lcom/google/android/gms/maps/model/LatLng;FLcom/google/android/gms/maps/model/LatLngBounds;Ljava/lang/String;Landroid/net/Uri;ZFIJ)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gms/internal/gx;",
            ">;",
            "Landroid/os/Bundle;",
            "Lcom/google/android/gms/internal/hf;",
            "Lcom/google/android/gms/maps/model/LatLng;",
            "F",
            "Lcom/google/android/gms/maps/model/LatLngBounds;",
            "Ljava/lang/String;",
            "Landroid/net/Uri;",
            "ZFIJ)V"
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/android/gms/internal/iy;-><init>()V

    iput p1, p0, Lcom/google/android/gms/internal/hd;->a:I

    iput-object p2, p0, Lcom/google/android/gms/internal/hd;->b:Ljava/lang/String;

    invoke-static {p3}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v2

    iput-object v2, p0, Lcom/google/android/gms/internal/hd;->n:Ljava/util/List;

    iput-object p4, p0, Lcom/google/android/gms/internal/hd;->c:Landroid/os/Bundle;

    iput-object p5, p0, Lcom/google/android/gms/internal/hd;->d:Lcom/google/android/gms/internal/hf;

    iput-object p6, p0, Lcom/google/android/gms/internal/hd;->e:Lcom/google/android/gms/maps/model/LatLng;

    iput p7, p0, Lcom/google/android/gms/internal/hd;->f:F

    iput-object p8, p0, Lcom/google/android/gms/internal/hd;->g:Lcom/google/android/gms/maps/model/LatLngBounds;

    iput-object p9, p0, Lcom/google/android/gms/internal/hd;->h:Ljava/lang/String;

    move-object/from16 v0, p10

    iput-object v0, p0, Lcom/google/android/gms/internal/hd;->i:Landroid/net/Uri;

    move/from16 v0, p11

    iput-boolean v0, p0, Lcom/google/android/gms/internal/hd;->j:Z

    move/from16 v0, p12

    iput v0, p0, Lcom/google/android/gms/internal/hd;->k:F

    move/from16 v0, p13

    iput v0, p0, Lcom/google/android/gms/internal/hd;->l:I

    move-wide/from16 v0, p14

    iput-wide v0, p0, Lcom/google/android/gms/internal/hd;->m:J

    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    invoke-virtual {p4}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Lcom/google/android/gms/internal/gx;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/gx;

    move-result-object v5

    invoke-virtual {p4, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v5, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_0
    invoke-static {v3}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v2

    iput-object v2, p0, Lcom/google/android/gms/internal/hd;->o:Ljava/util/Map;

    iget-object v2, p0, Lcom/google/android/gms/internal/hd;->h:Ljava/lang/String;

    invoke-static {v2}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v2

    iput-object v2, p0, Lcom/google/android/gms/internal/hd;->p:Ljava/util/TimeZone;

    const/4 v2, 0x0

    iput-object v2, p0, Lcom/google/android/gms/internal/hd;->q:Ljava/util/Locale;

    const/4 v2, 0x0

    iput-object v2, p0, Lcom/google/android/gms/internal/hd;->r:Lcom/google/android/gms/internal/jm;

    return-void
.end method


# virtual methods
.method final a(Ljava/lang/String;)V
    .locals 7

    iget-object v0, p0, Lcom/google/android/gms/internal/hd;->r:Lcom/google/android/gms/internal/jm;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/hd;->r:Lcom/google/android/gms/internal/jm;

    new-instance v5, Lcom/google/android/gms/internal/jj;

    iget-object v1, p0, Lcom/google/android/gms/internal/hd;->b:Ljava/lang/String;

    invoke-direct {v5, v1, p1}, Lcom/google/android/gms/internal/jj;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, v0, Lcom/google/android/gms/internal/jm;->a:Ljava/lang/String;

    iput-object v1, v5, Lcom/google/android/gms/internal/jj;->c:Ljava/lang/String;

    iget v1, v0, Lcom/google/android/gms/internal/jm;->b:I

    iput v1, v5, Lcom/google/android/gms/internal/jj;->d:I

    iget-object v6, v0, Lcom/google/android/gms/internal/jm;->c:Ljava/util/concurrent/BlockingQueue;

    new-instance v0, Lcom/google/android/gms/internal/hd$a;

    const/4 v1, 0x0

    iget-object v2, v5, Lcom/google/android/gms/internal/jj;->a:Ljava/lang/String;

    iget-object v3, v5, Lcom/google/android/gms/internal/jj;->b:Ljava/lang/String;

    iget-object v4, v5, Lcom/google/android/gms/internal/jj;->c:Ljava/lang/String;

    iget v5, v5, Lcom/google/android/gms/internal/jj;->d:I

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/hd$a;-><init>(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    invoke-interface {v6, v0}, Ljava/util/concurrent/BlockingQueue;->offer(Ljava/lang/Object;)Z

    :cond_0
    return-void
.end method

.method public final describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public final equals(Ljava/lang/Object;)Z
    .locals 6

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-ne p0, p1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    instance-of v2, p1, Lcom/google/android/gms/internal/hd;

    if-nez v2, :cond_2

    move v0, v1

    goto :goto_0

    :cond_2
    check-cast p1, Lcom/google/android/gms/internal/hd;

    iget-object v2, p0, Lcom/google/android/gms/internal/hd;->b:Ljava/lang/String;

    iget-object v3, p1, Lcom/google/android/gms/internal/hd;->b:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/google/android/gms/internal/hd;->q:Ljava/util/Locale;

    iget-object v3, p1, Lcom/google/android/gms/internal/hd;->q:Ljava/util/Locale;

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/gw;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    iget-wide v2, p0, Lcom/google/android/gms/internal/hd;->m:J

    iget-wide v4, p1, Lcom/google/android/gms/internal/hd;->m:J

    cmp-long v2, v2, v4

    if-eqz v2, :cond_0

    :cond_3
    move v0, v1

    goto :goto_0
.end method

.method public final hashCode()I
    .locals 4

    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/google/android/gms/internal/hd;->b:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/google/android/gms/internal/hd;->q:Ljava/util/Locale;

    aput-object v2, v0, v1

    const/4 v1, 0x2

    iget-wide v2, p0, Lcom/google/android/gms/internal/hd;->m:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public final toString()Ljava/lang/String;
    .locals 4

    invoke-static {p0}, Lcom/google/android/gms/internal/gw;->a(Ljava/lang/Object;)Lcom/google/android/gms/internal/gy;

    move-result-object v0

    const-string v1, "id"

    iget-object v2, p0, Lcom/google/android/gms/internal/hd;->b:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/gy;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/gy;

    move-result-object v0

    const-string v1, "localization"

    iget-object v2, p0, Lcom/google/android/gms/internal/hd;->d:Lcom/google/android/gms/internal/hf;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/gy;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/gy;

    move-result-object v0

    const-string v1, "locale"

    iget-object v2, p0, Lcom/google/android/gms/internal/hd;->q:Ljava/util/Locale;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/gy;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/gy;

    move-result-object v0

    const-string v1, "latlng"

    iget-object v2, p0, Lcom/google/android/gms/internal/hd;->e:Lcom/google/android/gms/maps/model/LatLng;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/gy;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/gy;

    move-result-object v0

    const-string v1, "levelNumber"

    iget v2, p0, Lcom/google/android/gms/internal/hd;->f:F

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/gy;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/gy;

    move-result-object v0

    const-string v1, "viewport"

    iget-object v2, p0, Lcom/google/android/gms/internal/hd;->g:Lcom/google/android/gms/maps/model/LatLngBounds;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/gy;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/gy;

    move-result-object v0

    const-string v1, "timeZone"

    iget-object v2, p0, Lcom/google/android/gms/internal/hd;->h:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/gy;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/gy;

    move-result-object v0

    const-string v1, "websiteUri"

    iget-object v2, p0, Lcom/google/android/gms/internal/hd;->i:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/gy;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/gy;

    move-result-object v0

    const-string v1, "isPermanentlyClosed"

    iget-boolean v2, p0, Lcom/google/android/gms/internal/hd;->j:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/gy;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/gy;

    move-result-object v0

    const-string v1, "priceLevel"

    iget v2, p0, Lcom/google/android/gms/internal/hd;->l:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/gy;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/gy;

    move-result-object v0

    const-string v1, "timestampSecs"

    iget-wide v2, p0, Lcom/google/android/gms/internal/hd;->m:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/gy;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/gy;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gy;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final writeToParcel(Landroid/os/Parcel;I)V
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/jk;->a(Lcom/google/android/gms/internal/hd;Landroid/os/Parcel;I)V

    return-void
.end method
