.class Lsp$2;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lsp;-><init>(Lcom/google/android/gms/internal/ay;Labd;Lcom/google/android/gms/internal/gs;Landroid/view/View;Lsr;)V
.end annotation


# instance fields
.field final synthetic a:Lorg/json/JSONObject;

.field final synthetic b:Lsp;


# direct methods
.method constructor <init>(Lsp;Lorg/json/JSONObject;)V
    .locals 0

    iput-object p1, p0, Lsp$2;->b:Lsp;

    iput-object p2, p0, Lsp$2;->a:Lorg/json/JSONObject;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lsp$2;->b:Lsp;

    iget-object v1, p0, Lsp$2;->a:Lorg/json/JSONObject;

    invoke-virtual {v0, v1}, Lsp;->a(Lorg/json/JSONObject;)V

    return-void
.end method
