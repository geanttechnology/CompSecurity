.class Lwu$2;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lwu;->a()V
.end annotation


# instance fields
.field final synthetic a:Lwu;


# direct methods
.method constructor <init>(Lwu;)V
    .locals 0

    iput-object p1, p0, Lwu$2;->a:Lwu;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3

    iget-object v0, p0, Lwu$2;->a:Lwu;

    invoke-static {v0}, Lwu;->b(Lwu;)Lcom/google/android/gms/internal/gu;

    move-result-object v0

    const-string v1, "onCalendarEventCanceled"

    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/gu;->b(Ljava/lang/String;Lorg/json/JSONObject;)V

    return-void
.end method
