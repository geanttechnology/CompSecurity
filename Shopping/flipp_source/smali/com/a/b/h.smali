.class public interface abstract Lcom/a/b/h;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final a:Lcom/a/b/h;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 44
    new-instance v0, Lcom/a/b/i;

    invoke-direct {v0}, Lcom/a/b/i;-><init>()V

    sput-object v0, Lcom/a/b/h;->a:Lcom/a/b/h;

    return-void
.end method


# virtual methods
.method public abstract a()I
.end method

.method public abstract a(Ljava/lang/String;)Landroid/graphics/Bitmap;
.end method

.method public abstract a(Ljava/lang/String;Landroid/graphics/Bitmap;)V
.end method

.method public abstract b()I
.end method
