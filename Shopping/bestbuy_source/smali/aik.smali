.class public final Laik;
.super Ljava/lang/Object;


# instance fields
.field private final a:Lry;


# direct methods
.method constructor <init>(Lry;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Lady;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lry;

    iput-object v0, p0, Laik;->a:Lry;

    return-void
.end method


# virtual methods
.method public a()Lry;
    .locals 1

    iget-object v0, p0, Laik;->a:Lry;

    return-object v0
.end method
