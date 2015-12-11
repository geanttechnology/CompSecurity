.class final Lawi;
.super Lawf;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lawf",
        "<",
        "Lcom/google/android/gms/common/api/Status;",
        ">;"
    }
.end annotation


# instance fields
.field private b:Latt;

.field private c:[Landroid/content/IntentFilter;


# direct methods
.method private constructor <init>(Lqm;Latt;[Landroid/content/IntentFilter;)V
    .locals 0

    invoke-direct {p0, p1}, Lawf;-><init>(Lqm;)V

    iput-object p2, p0, Lawi;->b:Latt;

    iput-object p3, p0, Lawi;->c:[Landroid/content/IntentFilter;

    return-void
.end method

.method synthetic constructor <init>(Lqm;Latt;[Landroid/content/IntentFilter;Lawh$1;)V
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Lawi;-><init>(Lqm;Latt;[Landroid/content/IntentFilter;)V

    return-void
.end method


# virtual methods
.method public synthetic a(Lcom/google/android/gms/common/api/Status;)Lqt;
    .locals 1

    invoke-virtual {p0, p1}, Lawi;->c(Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/common/api/Status;

    move-result-object v0

    return-object v0
.end method

.method protected a(Lawc;)V
    .locals 3

    const/4 v2, 0x0

    iget-object v0, p0, Lawi;->b:Latt;

    iget-object v1, p0, Lawi;->c:[Landroid/content/IntentFilter;

    invoke-virtual {p1, p0, v0, v1}, Lawc;->a(Lqk;Latt;[Landroid/content/IntentFilter;)V

    iput-object v2, p0, Lawi;->b:Latt;

    iput-object v2, p0, Lawi;->c:[Landroid/content/IntentFilter;

    return-void
.end method

.method protected synthetic b(Lqd;)V
    .locals 0

    check-cast p1, Lawc;

    invoke-virtual {p0, p1}, Lawi;->a(Lawc;)V

    return-void
.end method

.method public c(Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/common/api/Status;
    .locals 1

    const/4 v0, 0x0

    iput-object v0, p0, Lawi;->b:Latt;

    iput-object v0, p0, Lawi;->c:[Landroid/content/IntentFilter;

    return-object p1
.end method
