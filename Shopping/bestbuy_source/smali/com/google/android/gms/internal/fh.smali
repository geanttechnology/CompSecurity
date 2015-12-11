.class public final Lcom/google/android/gms/internal/fh;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;


# annotations
.annotation runtime Lzf;
.end annotation


# static fields
.field public static final CREATOR:Laal;


# instance fields
.field public final a:I

.field public final b:Landroid/os/Bundle;

.field public final c:Lcom/google/android/gms/internal/av;

.field public final d:Lcom/google/android/gms/internal/ay;

.field public final e:Ljava/lang/String;

.field public final f:Landroid/content/pm/ApplicationInfo;

.field public final g:Landroid/content/pm/PackageInfo;

.field public final h:Ljava/lang/String;

.field public final i:Ljava/lang/String;

.field public final j:Ljava/lang/String;

.field public final k:Lcom/google/android/gms/internal/gs;

.field public final l:Landroid/os/Bundle;

.field public final m:I

.field public final n:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public final o:Landroid/os/Bundle;

.field public final p:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Laal;

    invoke-direct {v0}, Laal;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/fh;->CREATOR:Laal;

    return-void
.end method

.method public constructor <init>(ILandroid/os/Bundle;Lcom/google/android/gms/internal/av;Lcom/google/android/gms/internal/ay;Ljava/lang/String;Landroid/content/pm/ApplicationInfo;Landroid/content/pm/PackageInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/gs;Landroid/os/Bundle;ILjava/util/List;Landroid/os/Bundle;Z)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            "Lcom/google/android/gms/internal/av;",
            "Lcom/google/android/gms/internal/ay;",
            "Ljava/lang/String;",
            "Landroid/content/pm/ApplicationInfo;",
            "Landroid/content/pm/PackageInfo;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/internal/gs;",
            "Landroid/os/Bundle;",
            "I",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Landroid/os/Bundle;",
            "Z)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/google/android/gms/internal/fh;->a:I

    iput-object p2, p0, Lcom/google/android/gms/internal/fh;->b:Landroid/os/Bundle;

    iput-object p3, p0, Lcom/google/android/gms/internal/fh;->c:Lcom/google/android/gms/internal/av;

    iput-object p4, p0, Lcom/google/android/gms/internal/fh;->d:Lcom/google/android/gms/internal/ay;

    iput-object p5, p0, Lcom/google/android/gms/internal/fh;->e:Ljava/lang/String;

    iput-object p6, p0, Lcom/google/android/gms/internal/fh;->f:Landroid/content/pm/ApplicationInfo;

    iput-object p7, p0, Lcom/google/android/gms/internal/fh;->g:Landroid/content/pm/PackageInfo;

    iput-object p8, p0, Lcom/google/android/gms/internal/fh;->h:Ljava/lang/String;

    iput-object p9, p0, Lcom/google/android/gms/internal/fh;->i:Ljava/lang/String;

    iput-object p10, p0, Lcom/google/android/gms/internal/fh;->j:Ljava/lang/String;

    iput-object p11, p0, Lcom/google/android/gms/internal/fh;->k:Lcom/google/android/gms/internal/gs;

    iput-object p12, p0, Lcom/google/android/gms/internal/fh;->l:Landroid/os/Bundle;

    iput p13, p0, Lcom/google/android/gms/internal/fh;->m:I

    iput-object p14, p0, Lcom/google/android/gms/internal/fh;->n:Ljava/util/List;

    move-object/from16 v0, p15

    iput-object v0, p0, Lcom/google/android/gms/internal/fh;->o:Landroid/os/Bundle;

    move/from16 v0, p16

    iput-boolean v0, p0, Lcom/google/android/gms/internal/fh;->p:Z

    return-void
.end method

.method public constructor <init>(Laak;Ljava/lang/String;)V
    .locals 17

    move-object/from16 v0, p1

    iget-object v2, v0, Laak;->a:Landroid/os/Bundle;

    move-object/from16 v0, p1

    iget-object v3, v0, Laak;->b:Lcom/google/android/gms/internal/av;

    move-object/from16 v0, p1

    iget-object v4, v0, Laak;->c:Lcom/google/android/gms/internal/ay;

    move-object/from16 v0, p1

    iget-object v5, v0, Laak;->d:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-object v6, v0, Laak;->e:Landroid/content/pm/ApplicationInfo;

    move-object/from16 v0, p1

    iget-object v7, v0, Laak;->f:Landroid/content/pm/PackageInfo;

    move-object/from16 v0, p1

    iget-object v9, v0, Laak;->g:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-object v10, v0, Laak;->h:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-object v11, v0, Laak;->j:Lcom/google/android/gms/internal/gs;

    move-object/from16 v0, p1

    iget-object v12, v0, Laak;->i:Landroid/os/Bundle;

    move-object/from16 v0, p1

    iget v13, v0, Laak;->k:I

    move-object/from16 v0, p1

    iget-object v14, v0, Laak;->l:Ljava/util/List;

    move-object/from16 v0, p1

    iget-object v15, v0, Laak;->m:Landroid/os/Bundle;

    move-object/from16 v0, p1

    iget-boolean v0, v0, Laak;->n:Z

    move/from16 v16, v0

    move-object/from16 v1, p0

    move-object/from16 v8, p2

    invoke-direct/range {v1 .. v16}, Lcom/google/android/gms/internal/fh;-><init>(Landroid/os/Bundle;Lcom/google/android/gms/internal/av;Lcom/google/android/gms/internal/ay;Ljava/lang/String;Landroid/content/pm/ApplicationInfo;Landroid/content/pm/PackageInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/gs;Landroid/os/Bundle;ILjava/util/List;Landroid/os/Bundle;Z)V

    return-void
.end method

.method public constructor <init>(Landroid/os/Bundle;Lcom/google/android/gms/internal/av;Lcom/google/android/gms/internal/ay;Ljava/lang/String;Landroid/content/pm/ApplicationInfo;Landroid/content/pm/PackageInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/gs;Landroid/os/Bundle;ILjava/util/List;Landroid/os/Bundle;Z)V
    .locals 17
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Bundle;",
            "Lcom/google/android/gms/internal/av;",
            "Lcom/google/android/gms/internal/ay;",
            "Ljava/lang/String;",
            "Landroid/content/pm/ApplicationInfo;",
            "Landroid/content/pm/PackageInfo;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/internal/gs;",
            "Landroid/os/Bundle;",
            "I",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Landroid/os/Bundle;",
            "Z)V"
        }
    .end annotation

    const/4 v1, 0x4

    move-object/from16 v0, p0

    move-object/from16 v2, p1

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    move-object/from16 v6, p5

    move-object/from16 v7, p6

    move-object/from16 v8, p7

    move-object/from16 v9, p8

    move-object/from16 v10, p9

    move-object/from16 v11, p10

    move-object/from16 v12, p11

    move/from16 v13, p12

    move-object/from16 v14, p13

    move-object/from16 v15, p14

    move/from16 v16, p15

    invoke-direct/range {v0 .. v16}, Lcom/google/android/gms/internal/fh;-><init>(ILandroid/os/Bundle;Lcom/google/android/gms/internal/av;Lcom/google/android/gms/internal/ay;Ljava/lang/String;Landroid/content/pm/ApplicationInfo;Landroid/content/pm/PackageInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/gs;Landroid/os/Bundle;ILjava/util/List;Landroid/os/Bundle;Z)V

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 0

    invoke-static {p0, p1, p2}, Laal;->a(Lcom/google/android/gms/internal/fh;Landroid/os/Parcel;I)V

    return-void
.end method
