.class Laim$4;
.super Lals;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laim;->a(Laip;)V
.end annotation


# instance fields
.field final synthetic a:Laip;

.field final synthetic b:Laim;


# direct methods
.method constructor <init>(Laim;Laip;)V
    .locals 0

    iput-object p1, p0, Laim$4;->b:Laim;

    iput-object p2, p0, Laim$4;->a:Laip;

    invoke-direct {p0}, Lals;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/google/android/gms/maps/model/LatLng;)V
    .locals 1

    iget-object v0, p0, Laim$4;->a:Laip;

    invoke-interface {v0, p1}, Laip;->a(Lcom/google/android/gms/maps/model/LatLng;)V

    return-void
.end method
