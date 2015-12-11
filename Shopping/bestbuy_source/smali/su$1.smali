.class Lsu$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lsu;->a(Ljava/lang/String;Lorg/json/JSONObject;)V
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lorg/json/JSONObject;

.field final synthetic c:Lsu;


# direct methods
.method constructor <init>(Lsu;Ljava/lang/String;Lorg/json/JSONObject;)V
    .locals 0

    iput-object p1, p0, Lsu$1;->c:Lsu;

    iput-object p2, p0, Lsu$1;->a:Ljava/lang/String;

    iput-object p3, p0, Lsu$1;->b:Lorg/json/JSONObject;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    iget-object v0, p0, Lsu$1;->c:Lsu;

    invoke-static {v0}, Lsu;->a(Lsu;)Lcom/google/android/gms/internal/gu;

    move-result-object v0

    iget-object v1, p0, Lsu$1;->a:Ljava/lang/String;

    iget-object v2, p0, Lsu$1;->b:Lorg/json/JSONObject;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/gu;->a(Ljava/lang/String;Lorg/json/JSONObject;)V

    return-void
.end method
