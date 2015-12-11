.class final Lb/a/a/d/ag;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lb/a/a/d/al;
.implements Lb/a/a/d/am;


# instance fields
.field final a:I

.field private final b:I

.field private final c:I

.field private final d:I

.field private final e:Z

.field private final f:[Lb/a/a/d/ag;

.field private final g:Lb/a/a/d/ai;

.field private final h:Lb/a/a/d/ai;


# direct methods
.method constructor <init>(IIIZI[Lb/a/a/d/ag;Lb/a/a/d/ai;)V
    .locals 1

    .prologue
    .line 1053
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1054
    iput p1, p0, Lb/a/a/d/ag;->b:I

    .line 1055
    iput p2, p0, Lb/a/a/d/ag;->c:I

    .line 1056
    iput p3, p0, Lb/a/a/d/ag;->d:I

    .line 1057
    iput-boolean p4, p0, Lb/a/a/d/ag;->e:Z

    .line 1058
    iput p5, p0, Lb/a/a/d/ag;->a:I

    .line 1059
    iput-object p6, p0, Lb/a/a/d/ag;->f:[Lb/a/a/d/ag;

    .line 1060
    iput-object p7, p0, Lb/a/a/d/ag;->g:Lb/a/a/d/ai;

    .line 1061
    const/4 v0, 0x0

    iput-object v0, p0, Lb/a/a/d/ag;->h:Lb/a/a/d/ai;

    .line 1062
    return-void
.end method

.method constructor <init>(Lb/a/a/d/ag;Lb/a/a/d/ai;)V
    .locals 2

    .prologue
    .line 1064
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1065
    iget v0, p1, Lb/a/a/d/ag;->b:I

    iput v0, p0, Lb/a/a/d/ag;->b:I

    .line 1066
    iget v0, p1, Lb/a/a/d/ag;->c:I

    iput v0, p0, Lb/a/a/d/ag;->c:I

    .line 1067
    iget v0, p1, Lb/a/a/d/ag;->d:I

    iput v0, p0, Lb/a/a/d/ag;->d:I

    .line 1068
    iget-boolean v0, p1, Lb/a/a/d/ag;->e:Z

    iput-boolean v0, p0, Lb/a/a/d/ag;->e:Z

    .line 1069
    iget v0, p1, Lb/a/a/d/ag;->a:I

    iput v0, p0, Lb/a/a/d/ag;->a:I

    .line 1070
    iget-object v0, p1, Lb/a/a/d/ag;->f:[Lb/a/a/d/ag;

    iput-object v0, p0, Lb/a/a/d/ag;->f:[Lb/a/a/d/ag;

    .line 1071
    iget-object v0, p1, Lb/a/a/d/ag;->g:Lb/a/a/d/ai;

    iput-object v0, p0, Lb/a/a/d/ag;->g:Lb/a/a/d/ai;

    .line 1072
    iget-object v0, p1, Lb/a/a/d/ag;->h:Lb/a/a/d/ai;

    if-eqz v0, :cond_0

    .line 1073
    new-instance v0, Lb/a/a/d/af;

    iget-object v1, p1, Lb/a/a/d/ag;->h:Lb/a/a/d/ai;

    invoke-direct {v0, v1, p2}, Lb/a/a/d/af;-><init>(Lb/a/a/d/ai;Lb/a/a/d/ai;)V

    move-object p2, v0

    .line 1075
    :cond_0
    iput-object p2, p0, Lb/a/a/d/ag;->h:Lb/a/a/d/ai;

    .line 1076
    return-void
.end method
