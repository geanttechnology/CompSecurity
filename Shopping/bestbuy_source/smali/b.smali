.class public Lb;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:Ljava/lang/String;

.field final b:Landroid/content/Context;

.field final c:Ljava/lang/String;

.field final d:Ljava/lang/String;

.field final e:Z

.field final f:Lf;

.field final g:Z


# direct methods
.method constructor <init>(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLf;Z)V
    .locals 0

    .prologue
    .line 171
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 172
    iput-object p1, p0, Lb;->a:Ljava/lang/String;

    .line 173
    iput-object p2, p0, Lb;->b:Landroid/content/Context;

    .line 174
    iput-object p3, p0, Lb;->c:Ljava/lang/String;

    .line 175
    iput-object p4, p0, Lb;->d:Ljava/lang/String;

    .line 176
    iput-boolean p5, p0, Lb;->e:Z

    .line 177
    iput-object p6, p0, Lb;->f:Lf;

    .line 178
    iput-boolean p7, p0, Lb;->g:Z

    .line 179
    return-void
.end method

.method public static a()Lc;
    .locals 2

    .prologue
    .line 185
    new-instance v0, Lc;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lc;-><init>(Lb$1;)V

    return-object v0
.end method
