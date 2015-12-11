.class public final Lcom/google/android/gms/internal/o;
.super Ljava/lang/Object;


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field public final b:Ljava/util/Date;

.field public final c:I

.field public final d:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public final e:Landroid/location/Location;

.field public final f:Z

.field final g:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Class",
            "<+",
            "Lcom/google/android/gms/ads/mediation/NetworkExtras;",
            ">;",
            "Lcom/google/android/gms/ads/mediation/NetworkExtras;",
            ">;"
        }
    .end annotation
.end field

.field public final h:Ljava/lang/String;

.field final i:Lcom/google/android/gms/ads/search/SearchAdRequest;

.field final j:I

.field private final k:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-string v0, "emulator"

    invoke-static {v0}, Lcom/google/android/gms/internal/er;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/internal/o;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/internal/p;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/o;-><init>(Lcom/google/android/gms/internal/p;Lcom/google/android/gms/ads/search/SearchAdRequest;)V

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/internal/p;Lcom/google/android/gms/ads/search/SearchAdRequest;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iget-object v0, p1, Lcom/google/android/gms/internal/p;->d:Ljava/util/Date;

    iput-object v0, p0, Lcom/google/android/gms/internal/o;->b:Ljava/util/Date;

    iget v0, p1, Lcom/google/android/gms/internal/p;->e:I

    iput v0, p0, Lcom/google/android/gms/internal/o;->c:I

    iget-object v0, p1, Lcom/google/android/gms/internal/p;->a:Ljava/util/HashSet;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/o;->d:Ljava/util/Set;

    iget-object v0, p1, Lcom/google/android/gms/internal/p;->f:Landroid/location/Location;

    iput-object v0, p0, Lcom/google/android/gms/internal/o;->e:Landroid/location/Location;

    iget-boolean v0, p1, Lcom/google/android/gms/internal/p;->g:Z

    iput-boolean v0, p0, Lcom/google/android/gms/internal/o;->f:Z

    iget-object v0, p1, Lcom/google/android/gms/internal/p;->b:Ljava/util/HashMap;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/o;->g:Ljava/util/Map;

    iget-object v0, p1, Lcom/google/android/gms/internal/p;->h:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/o;->h:Ljava/lang/String;

    iput-object p2, p0, Lcom/google/android/gms/internal/o;->i:Lcom/google/android/gms/ads/search/SearchAdRequest;

    iget v0, p1, Lcom/google/android/gms/internal/p;->i:I

    iput v0, p0, Lcom/google/android/gms/internal/o;->j:I

    iget-object v0, p1, Lcom/google/android/gms/internal/p;->c:Ljava/util/HashSet;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/o;->k:Ljava/util/Set;

    return-void
.end method


# virtual methods
.method public final a(Ljava/lang/Class;)Lcom/google/android/gms/ads/mediation/NetworkExtras;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Lcom/google/android/gms/ads/mediation/NetworkExtras;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;)TT;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/o;->g:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/ads/mediation/NetworkExtras;

    return-object v0
.end method

.method public final a(Landroid/content/Context;)Z
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/o;->k:Ljava/util/Set;

    invoke-static {p1}, Lcom/google/android/gms/internal/er;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method
