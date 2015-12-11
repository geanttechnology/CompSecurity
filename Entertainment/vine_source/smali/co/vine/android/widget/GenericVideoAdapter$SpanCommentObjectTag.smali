.class public Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;
.super Ljava/lang/Object;
.source "GenericVideoAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/widget/GenericVideoAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "SpanCommentObjectTag"
.end annotation


# instance fields
.field public final authorId:J

.field public final postId:J

.field final synthetic this$0:Lco/vine/android/widget/GenericVideoAdapter;


# direct methods
.method public constructor <init>(Lco/vine/android/widget/GenericVideoAdapter;JJ)V
    .locals 0
    .param p2, "postId"    # J
    .param p4, "authorId"    # J

    .prologue
    .line 677
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>.SpanCommentObjectTag;"
    iput-object p1, p0, Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;->this$0:Lco/vine/android/widget/GenericVideoAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 678
    iput-wide p2, p0, Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;->postId:J

    .line 679
    iput-wide p4, p0, Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;->authorId:J

    .line 680
    return-void
.end method
