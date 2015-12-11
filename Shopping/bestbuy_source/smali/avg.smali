.class final Lavg;
.super Lave;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lave",
        "<",
        "Latt;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lave;-><init>()V

    return-void
.end method


# virtual methods
.method a(Latt;[Landroid/content/IntentFilter;)Lawd;
    .locals 1

    invoke-static {p1, p2}, Lawd;->a(Latt;[Landroid/content/IntentFilter;)Lawd;

    move-result-object v0

    return-object v0
.end method

.method bridge synthetic a(Ljava/lang/Object;[Landroid/content/IntentFilter;)Lawd;
    .locals 1

    check-cast p1, Latt;

    invoke-virtual {p0, p1, p2}, Lavg;->a(Latt;[Landroid/content/IntentFilter;)Lawd;

    move-result-object v0

    return-object v0
.end method
