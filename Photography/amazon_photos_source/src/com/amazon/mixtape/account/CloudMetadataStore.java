// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.account;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;
import com.amazon.clouddrive.extended.model.NodeExtended;
import com.amazon.clouddrive.model.CollectionProperties;
import com.amazon.clouddrive.model.ContentProperties;
import com.amazon.clouddrive.model.CoverObject;
import com.amazon.clouddrive.model.DocumentProperties;
import com.amazon.clouddrive.model.ImageProperties;
import com.amazon.clouddrive.model.QueryAndBlock;
import com.amazon.clouddrive.model.QueryFilter;
import com.amazon.clouddrive.model.QueryObject;
import com.amazon.clouddrive.model.Settings;
import com.amazon.clouddrive.model.VideoProperties;
import com.amazon.mixtape.database.CloudMediaParentsRollupHelper;
import com.amazon.mixtape.service.MetadataSyncException;
import com.amazon.mixtape.utils.DateUtils;
import com.amazon.mixtape.utils.ISO8601;
import com.amazon.mixtape.utils.TransactionExecutor;
import java.io.Closeable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.mixtape.account:
//            MetadataStore, NodePropertiesOperationCreator

class CloudMetadataStore
    implements MetadataStore
{
    private static class DocumentAuthorsOperationCreator
        implements Closeable
    {

        private final Uri mContentUri;
        private final SQLiteStatement mInsertStatement;

        public void close()
        {
            mInsertStatement.close();
        }

        void insert(long l, NodeExtended nodeextended, Set set)
        {
            set.add(mContentUri);
            if (nodeextended.getContentProperties() != null && nodeextended.getContentProperties().getDocument() != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            if ((set = nodeextended.getContentProperties().getDocument().getAuthors()) != null && !set.isEmpty())
            {
                set = set.iterator();
                while (set.hasNext()) 
                {
                    String s = (String)set.next();
                    CloudMetadataStore.bindValue(mInsertStatement, 1, Long.valueOf(l));
                    CloudMetadataStore.bindValue(mInsertStatement, 2, nodeextended.getId());
                    CloudMetadataStore.bindValue(mInsertStatement, 3, s);
                    mInsertStatement.execute();
                    mInsertStatement.clearBindings();
                }
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        private DocumentAuthorsOperationCreator(SQLiteDatabase sqlitedatabase, String s, String s1)
        {
            mInsertStatement = sqlitedatabase.compileStatement("INSERT INTO document_authors(event_id, node_id, author) VALUES (?, ?, ?);");
            mContentUri = com.amazon.mixtape.provider.CloudNodesContract.DocumentAuthors.getContentUri(s, s1);
        }

    }

    private static class EventsOperationCreator
        implements Closeable
    {

        private final SQLiteStatement mInsertStatement;

        public void close()
        {
            mInsertStatement.close();
        }

        public long insert(NodeExtended nodeextended)
        {
            long l;
            CloudMetadataStore.bindValue(mInsertStatement, 1, nodeextended.getId());
            CloudMetadataStore.bindValue(mInsertStatement, 2, CloudMetadataStore.getChangeType(nodeextended));
            l = mInsertStatement.executeInsert();
            mInsertStatement.clearBindings();
            return l;
            nodeextended;
            mInsertStatement.clearBindings();
            throw nodeextended;
        }

        private EventsOperationCreator(SQLiteDatabase sqlitedatabase)
        {
            mInsertStatement = sqlitedatabase.compileStatement("INSERT INTO events (changed_object_id, change_type) VALUES (?, ?);");
        }

    }

    private static class NodeCoverPhotosOperationCreator
        implements Closeable
    {

        private final SQLiteStatement mInsertStatement;
        private final Uri mNodeCoverPhotosUri;

        public void close()
        {
            mInsertStatement.close();
        }

        void insert(long l, NodeExtended nodeextended, Set set)
        {
            if (nodeextended.getCollectionProperties() != null)
            {
                Object obj = nodeextended.getCollectionProperties().getCovers();
                if (obj != null)
                {
                    for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); mInsertStatement.clearBindings())
                    {
                        CoverObject coverobject = (CoverObject)((Iterator) (obj)).next();
                        mInsertStatement.bindLong(1, l);
                        mInsertStatement.bindString(2, nodeextended.getId());
                        mInsertStatement.bindString(3, coverobject.getId());
                        mInsertStatement.executeInsert();
                    }

                    set.add(mNodeCoverPhotosUri);
                    set.add(mNodeCoverPhotosUri.buildUpon().appendPath(nodeextended.getId()).build());
                }
            }
        }

        private NodeCoverPhotosOperationCreator(SQLiteDatabase sqlitedatabase, String s, String s1)
        {
            mInsertStatement = sqlitedatabase.compileStatement("INSERT INTO cloud_node_cover_photos (event_id, node_id, cover_id) VALUES (?, ?, ?);");
            mNodeCoverPhotosUri = com.amazon.mixtape.provider.CloudNodesContract.NodeCoverPhotos.getContentUri(s, s1);
        }

    }

    private static class NodeLabelsOperationCreator
        implements Closeable
    {

        private final Uri mContentUri;
        private final SQLiteStatement mInsertStatement;

        public void close()
        {
            mInsertStatement.close();
        }

        void insert(long l, NodeExtended nodeextended, Set set)
        {
            set.add(mContentUri);
            if (nodeextended.getLabels() != null && !nodeextended.getLabels().isEmpty())
            {
                set = nodeextended.getLabels().iterator();
                while (set.hasNext()) 
                {
                    String s = (String)set.next();
                    mInsertStatement.bindLong(1, l);
                    mInsertStatement.bindString(2, nodeextended.getId());
                    mInsertStatement.bindString(3, s);
                    mInsertStatement.executeInsert();
                    mInsertStatement.clearBindings();
                }
            }
        }

        private NodeLabelsOperationCreator(SQLiteDatabase sqlitedatabase, String s, String s1)
        {
            mInsertStatement = sqlitedatabase.compileStatement("INSERT INTO cloud_node_labels (event_id, node_id, label) VALUES (?, ?, ?);");
            mContentUri = com.amazon.mixtape.provider.CloudNodesContract.NodeLabels.getContentUri(s, s1);
        }

    }

    private static class NodeOperationCreator
        implements Closeable
    {

        private final String mCloudNodesProviderAuthority;
        private final Uri mContentUri;
        private final SQLiteDatabase mDatabase;
        private final DocumentAuthorsOperationCreator mDocumentAuthorsOperationCreator;
        private final NodeCoverPhotosOperationCreator mNodeCoverPhotosOperationCreator;
        private final NodeLabelsOperationCreator mNodeLabelsOperationCreator;
        private final NodeParentsOperationCreator mNodeParentsOperationCreator;
        private final NodePropertiesOperationCreator mNodePropertiesOperationCreator;
        private final NodeQueryOperationCreator mNodeQueryOperationCreator;
        private final NodeTransformsOperationCreator mNodeTransformsOperationCreator;

        private void setNodeContentValues(ContentValues contentvalues, long l, NodeExtended nodeextended, String s)
        {
            contentvalues.put("event_id", Long.valueOf(l));
            contentvalues.put("node_id", nodeextended.getId());
            contentvalues.put("change_type", s);
            contentvalues.put("created_by", nodeextended.getCreatedBy());
            contentvalues.put("created_date", nodeextended.getCreatedDate());
            contentvalues.put("description", nodeextended.getDescription());
            contentvalues.put("exclusively_trashed", nodeextended.isExclusivelyTrashed());
            contentvalues.put("is_root", nodeextended.isRoot());
            contentvalues.put("is_shared", nodeextended.isShared());
            contentvalues.put("kind", nodeextended.getKind());
            contentvalues.put("modified_date", nodeextended.getModifiedDate());
            contentvalues.put("name", nodeextended.getName());
            contentvalues.put("recursively_trashed", nodeextended.isRecursivelyTrashed());
            contentvalues.put("restricted", nodeextended.isRestricted());
            contentvalues.put("status", nodeextended.getStatus());
            contentvalues.put("version", Long.valueOf(nodeextended.getVersion()));
            contentvalues.put("metadata_version", Integer.valueOf(5));
            s = nodeextended.getContentProperties();
            boolean flag;
            if (s != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            contentvalues.put("is_content", Boolean.valueOf(flag));
            if (s != null)
            {
                contentvalues.put("content_date", s.getContentDate());
                contentvalues.put("content_type", s.getContentType());
                contentvalues.put("content_extension", s.getExtension());
                contentvalues.put("content_md5", s.getMd5());
                contentvalues.put("content_size", s.getSize());
                contentvalues.put("content_version", s.getVersion());
                contentvalues.put("content_sort_date", DateUtils.getSortDate(nodeextended));
                Object obj = s.getDocument();
                if (obj != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                contentvalues.put("is_document", Boolean.valueOf(flag));
                if (obj != null)
                {
                    contentvalues.put("document_version", ((DocumentProperties) (obj)).getDocumentVersion());
                    contentvalues.put("document_title", ((DocumentProperties) (obj)).getTitle());
                }
                obj = s.getImage();
                if (obj != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                contentvalues.put("is_image", Boolean.valueOf(flag));
                if (obj != null)
                {
                    contentvalues.put("image_aperture_value", ((ImageProperties) (obj)).getApertureValue());
                    contentvalues.put("image_capture_mode", ((ImageProperties) (obj)).getCaptureMode());
                    contentvalues.put("image_color_space", ((ImageProperties) (obj)).getColorSpace());
                    contentvalues.put("image_date_time", ((ImageProperties) (obj)).getDateTime());
                    contentvalues.put("image_date_time_digitized", ((ImageProperties) (obj)).getDateTimeDigitized());
                    contentvalues.put("image_date_time_original", ((ImageProperties) (obj)).getDateTimeOriginal());
                    contentvalues.put("image_exposure_mode", ((ImageProperties) (obj)).getExposureMode());
                    contentvalues.put("image_exposure_program", ((ImageProperties) (obj)).getExposureProgram());
                    contentvalues.put("image_exposure_time", ((ImageProperties) (obj)).getExposureTime());
                    contentvalues.put("image_flash", ((ImageProperties) (obj)).getFlash());
                    contentvalues.put("image_focal_length", ((ImageProperties) (obj)).getFocalLength());
                    contentvalues.put("image_gps_time_stamp", ((ImageProperties) (obj)).getGpsTimeStamp());
                    contentvalues.put("image_height", ((ImageProperties) (obj)).getHeight());
                    contentvalues.put("image_iso_speed_ratings", ((ImageProperties) (obj)).getIsoSpeedRatings());
                    contentvalues.put("image_location", ((ImageProperties) (obj)).getLocation());
                    contentvalues.put("image_make", ((ImageProperties) (obj)).getMake());
                    contentvalues.put("image_metering_mode", ((ImageProperties) (obj)).getMeteringMode());
                    contentvalues.put("image_model", ((ImageProperties) (obj)).getModel());
                    contentvalues.put("image_orientation", ((ImageProperties) (obj)).getOrientation());
                    contentvalues.put("image_resolution_unit", ((ImageProperties) (obj)).getResolutionUnit());
                    contentvalues.put("image_sensing_method", ((ImageProperties) (obj)).getSensingMethod());
                    contentvalues.put("image_sharpness", ((ImageProperties) (obj)).getSharpness());
                    contentvalues.put("image_software", ((ImageProperties) (obj)).getSoftware());
                    contentvalues.put("image_white_balance", ((ImageProperties) (obj)).getWhiteBalance());
                    contentvalues.put("image_width", ((ImageProperties) (obj)).getWidth());
                    contentvalues.put("image_x_resolution", ((ImageProperties) (obj)).getXResolution());
                    contentvalues.put("image_y_resolution", ((ImageProperties) (obj)).getYResolution());
                }
                s = s.getVideo();
                if (s != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                contentvalues.put("is_video", Boolean.valueOf(flag));
                if (s != null)
                {
                    contentvalues.put("video_audio_bitrate", s.getAudioBitrate());
                    contentvalues.put("video_audio_channels", s.getAudioChannels());
                    contentvalues.put("video_audio_channel_layout", s.getAudioChannelLayout());
                    contentvalues.put("video_audio_codec", s.getAudioCodec());
                    contentvalues.put("video_audio_sample_rate", s.getAudioSampleRate());
                    contentvalues.put("video_creation_date", s.getCreationDate());
                    contentvalues.put("video_duration", s.getDuration());
                    contentvalues.put("video_encoder", s.getEncoder());
                    contentvalues.put("video_height", s.getHeight());
                    contentvalues.put("video_location", s.getLocation());
                    contentvalues.put("video_make", s.getMake());
                    contentvalues.put("video_model", s.getModel());
                    contentvalues.put("video_rotate", s.getRotate());
                    contentvalues.put("video_title", s.getTitle());
                    contentvalues.put("video_bitrate", s.getVideoBitrate());
                    contentvalues.put("video_overall_bitrate", s.getBitrate());
                    contentvalues.put("video_codec", s.getVideoCodec());
                    contentvalues.put("video_frame_rate", s.getVideoFrameRate());
                    contentvalues.put("video_width", s.getWidth());
                }
            }
            s = nodeextended.getSettings();
            if (s != null)
            {
                contentvalues.put("favorite", Boolean.valueOf(Boolean.TRUE.equals(s.isFavorite())));
                contentvalues.put("hidden", Boolean.valueOf(Boolean.TRUE.equals(s.isHidden())));
            } else
            {
                contentvalues.put("favorite", Boolean.valueOf(false));
                contentvalues.put("hidden", Boolean.valueOf(false));
            }
            nodeextended = nodeextended.getParentMap();
            if (nodeextended != null && nodeextended.containsKey("SHARED_COLLECTION"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            contentvalues.put("has_share_parent", Boolean.valueOf(flag));
        }

        public void close()
        {
            mNodeParentsOperationCreator.close();
            mNodePropertiesOperationCreator.close();
            mNodeLabelsOperationCreator.close();
            mDocumentAuthorsOperationCreator.close();
            mNodeTransformsOperationCreator.close();
            mNodeCoverPhotosOperationCreator.close();
            mNodeQueryOperationCreator.close();
        }

        public void insertOrUpdate(long l, NodeExtended nodeextended, Set set)
        {
            ContentValues contentvalues = new ContentValues();
            setNodeContentValues(contentvalues, l, nodeextended, CloudMetadataStore.getChangeType(nodeextended));
            if (mDatabase.insertWithOnConflict("cloud_nodes", null, contentvalues, 4) != -1L)
            {
                mNodeLabelsOperationCreator.insert(l, nodeextended, set);
                mNodeParentsOperationCreator.insert(l, nodeextended, set);
                mNodePropertiesOperationCreator.insert(l, nodeextended, set);
                mDocumentAuthorsOperationCreator.insert(l, nodeextended, set);
                mNodeTransformsOperationCreator.insert(l, nodeextended, set);
                mNodeCoverPhotosOperationCreator.insert(l, nodeextended, set);
                mNodeQueryOperationCreator.insert(l, nodeextended, set);
                set.add(mContentUri);
            } else
            {
                String as[] = com.amazon.mixtape.provider.CloudNodesContract.Nodes.ALL_COLUMNS;
                int j = as.length;
                for (int i = 0; i < j; i++)
                {
                    String s = as[i];
                    if (contentvalues.get(s) == null)
                    {
                        contentvalues.putNull(s);
                    }
                }

                if ((long)mDatabase.updateWithOnConflict("cloud_nodes", contentvalues, "node_id = ? AND ( version < ? OR metadata_version is null OR metadata_version < ? )", new String[] {
        nodeextended.getId(), Long.toString(nodeextended.getVersion()), contentvalues.getAsString("metadata_version")
    }, 4) > 0L)
                {
                    mNodeLabelsOperationCreator.insert(l, nodeextended, set);
                    mNodeParentsOperationCreator.insert(l, nodeextended, set);
                    mNodePropertiesOperationCreator.insert(l, nodeextended, set);
                    mDocumentAuthorsOperationCreator.insert(l, nodeextended, set);
                    mNodeTransformsOperationCreator.insert(l, nodeextended, set);
                    mNodeCoverPhotosOperationCreator.insert(l, nodeextended, set);
                    mNodeQueryOperationCreator.insert(l, nodeextended, set);
                    set.add(mContentUri);
                    return;
                }
            }
        }

        private NodeOperationCreator(SQLiteDatabase sqlitedatabase, String s, String s1)
        {
            mDatabase = sqlitedatabase;
            mCloudNodesProviderAuthority = s;
            mNodeLabelsOperationCreator = new NodeLabelsOperationCreator(sqlitedatabase, s, s1);
            mNodeParentsOperationCreator = new NodeParentsOperationCreator(sqlitedatabase, s, s1);
            mNodePropertiesOperationCreator = new NodePropertiesOperationCreator(sqlitedatabase, s, s1);
            mDocumentAuthorsOperationCreator = new DocumentAuthorsOperationCreator(sqlitedatabase, s, s1);
            mNodeTransformsOperationCreator = new NodeTransformsOperationCreator(sqlitedatabase, s, s1);
            mNodeCoverPhotosOperationCreator = new NodeCoverPhotosOperationCreator(sqlitedatabase, s, s1);
            mNodeQueryOperationCreator = new NodeQueryOperationCreator(sqlitedatabase, s, s1);
            mContentUri = com.amazon.mixtape.provider.CloudNodesContract.Nodes.getContentUri(mCloudNodesProviderAuthority, s1);
        }

    }

    private static class NodeParentsOperationCreator
        implements Closeable
    {

        private final SQLiteStatement mInsertStatement;
        private final Uri mMediaParentsUri;
        private final Uri mNodeChildrenUri;
        private final Uri mNodeParentsUri;

        public void close()
        {
            mInsertStatement.close();
        }

        void insert(long l, NodeExtended nodeextended, Set set)
        {
            if (nodeextended.getParents() != null && !nodeextended.getParents().isEmpty())
            {
                LinkedList linkedlist = new LinkedList();
                String s;
                for (Iterator iterator = nodeextended.getParents().iterator(); iterator.hasNext(); linkedlist.add(mNodeChildrenUri.buildUpon().appendPath(s).build()))
                {
                    s = (String)iterator.next();
                    mInsertStatement.bindLong(1, l);
                    mInsertStatement.bindString(2, nodeextended.getId());
                    mInsertStatement.bindString(3, s);
                    mInsertStatement.executeInsert();
                    mInsertStatement.clearBindings();
                }

                set.add(mNodeParentsUri);
                ContentProperties contentproperties = nodeextended.getContentProperties();
                if (contentproperties != null && (contentproperties.getImage() != null || contentproperties.getVideo() != null) && "FILE".equals(nodeextended.getKind()))
                {
                    set.add(mMediaParentsUri);
                }
                nodeextended = linkedlist.iterator();
                while (nodeextended.hasNext()) 
                {
                    set.add((Uri)nodeextended.next());
                }
            }
        }

        private NodeParentsOperationCreator(SQLiteDatabase sqlitedatabase, String s, String s1)
        {
            mInsertStatement = sqlitedatabase.compileStatement("INSERT INTO cloud_node_parents (event_id, node_id, parent_node_id) VALUES (?, ?, ?);");
            mNodeParentsUri = com.amazon.mixtape.provider.CloudNodesContract.NodeParents.getContentUri(s, s1);
            mMediaParentsUri = com.amazon.mixtape.provider.CloudNodesContract.MediaParents.getContentUri(s, s1);
            mNodeChildrenUri = com.amazon.mixtape.provider.CloudNodesContract.NodeChildren.getContentUri(s, s1);
        }

    }

    private static class NodeQueryOperationCreator
        implements Closeable
    {

        private final SQLiteStatement mInsertQueryExcludedIdsStatement;
        private final SQLiteStatement mInsertQueryIncludeStatement;
        private final Uri mNodeQueryExcludedIdsUri;
        private final Uri mNodeQueryIncludeUri;

        public void close()
        {
            mInsertQueryIncludeStatement.close();
            mInsertQueryExcludedIdsStatement.close();
        }

        void insert(long l, NodeExtended nodeextended, Set set)
        {
            boolean flag2 = false;
            boolean flag = false;
            int j = 0;
            int i = 0;
            if (nodeextended.getCollectionProperties() != null)
            {
                Object obj = nodeextended.getCollectionProperties().getQuery();
                if (obj != null)
                {
                    Object obj1 = ((QueryObject) (obj)).getExcludedIds();
                    if (obj1 != null)
                    {
                        obj1 = ((List) (obj1)).iterator();
                        do
                        {
                            flag2 = flag;
                            if (!((Iterator) (obj1)).hasNext())
                            {
                                break;
                            }
                            String s = (String)((Iterator) (obj1)).next();
                            insertExcludedIds(l, nodeextended.getId(), s);
                            flag = true;
                        } while (true);
                    }
                    obj = ((QueryObject) (obj)).getInclude();
                    if (obj != null)
                    {
                        j = 0;
                        boolean flag1 = i;
                        i = j;
                        do
                        {
                            j = ((flag1) ? 1 : 0);
                            if (i >= ((List) (obj)).size())
                            {
                                break;
                            }
                            List list = ((QueryAndBlock)((List) (obj)).get(i)).getFilters();
                            boolean flag3 = flag1;
                            if (list != null)
                            {
                                j = 0;
                                do
                                {
                                    flag3 = flag1;
                                    if (j >= list.size())
                                    {
                                        break;
                                    }
                                    QueryFilter queryfilter = (QueryFilter)list.get(j);
                                    flag3 = flag1;
                                    if (queryfilter.getValues() != null)
                                    {
                                        Iterator iterator = queryfilter.getValues().iterator();
                                        do
                                        {
                                            flag3 = flag1;
                                            if (!iterator.hasNext())
                                            {
                                                break;
                                            }
                                            String s1 = (String)iterator.next();
                                            insertInclude(l, nodeextended.getId(), i, j, queryfilter.getFilterType(), s1);
                                            flag1 = true;
                                        } while (true);
                                    }
                                    j++;
                                    flag1 = flag3;
                                } while (true);
                            }
                            i++;
                            flag1 = flag3;
                        } while (true);
                    }
                    if (flag2)
                    {
                        set.add(mNodeQueryExcludedIdsUri);
                        set.add(mNodeQueryExcludedIdsUri.buildUpon().appendPath(nodeextended.getId()).build());
                    }
                    if (j != 0)
                    {
                        set.add(mNodeQueryIncludeUri);
                        set.add(mNodeQueryIncludeUri.buildUpon().appendPath(nodeextended.getId()).build());
                    }
                }
            }
        }

        void insertExcludedIds(long l, String s, String s1)
        {
            mInsertQueryExcludedIdsStatement.bindLong(1, l);
            mInsertQueryExcludedIdsStatement.bindString(2, s);
            mInsertQueryExcludedIdsStatement.bindString(3, s1);
            mInsertQueryExcludedIdsStatement.executeInsert();
            mInsertQueryExcludedIdsStatement.clearBindings();
        }

        void insertInclude(long l, String s, int i, int j, String s1, String s2)
        {
            mInsertQueryIncludeStatement.bindLong(1, l);
            mInsertQueryIncludeStatement.bindString(2, s);
            mInsertQueryIncludeStatement.bindLong(3, i);
            mInsertQueryIncludeStatement.bindLong(4, j);
            mInsertQueryIncludeStatement.bindString(5, s1);
            mInsertQueryIncludeStatement.bindString(6, s2);
            mInsertQueryIncludeStatement.executeInsert();
            mInsertQueryIncludeStatement.clearBindings();
        }

        private NodeQueryOperationCreator(SQLiteDatabase sqlitedatabase, String s, String s1)
        {
            mInsertQueryExcludedIdsStatement = sqlitedatabase.compileStatement("INSERT INTO cloud_node_query_excluded_ids (event_id, node_id, excluded_node_id) VALUES (?, ?, ?);");
            mNodeQueryExcludedIdsUri = com.amazon.mixtape.provider.CloudNodesContract.NodeQueryExcludedIds.getContentUri(s, s1);
            mInsertQueryIncludeStatement = sqlitedatabase.compileStatement("INSERT INTO cloud_node_query_include (event_id, node_id, and_block_position, filter_position, filter_type, value) VALUES (?, ?, ?, ?, ?, ?);");
            mNodeQueryIncludeUri = com.amazon.mixtape.provider.CloudNodesContract.NodeQueryInclude.getContentUri(s, s1);
        }

    }

    private static class NodeTransformsOperationCreator
        implements Closeable
    {

        private final SQLiteStatement mInsertStatement;
        private final Uri mNodeTransformsUri;

        public void close()
        {
            mInsertStatement.close();
        }

        void insert(long l, NodeExtended nodeextended, Set set)
        {
            if (nodeextended.getTransforms() == null || nodeextended.getTransforms().isEmpty())
            {
                return;
            }
            for (Iterator iterator = nodeextended.getTransforms().iterator(); iterator.hasNext(); mInsertStatement.clearBindings())
            {
                String s = (String)iterator.next();
                mInsertStatement.bindLong(1, l);
                mInsertStatement.bindString(2, nodeextended.getId());
                mInsertStatement.bindString(3, s);
                mInsertStatement.executeInsert();
            }

            set.add(mNodeTransformsUri);
            set.add(mNodeTransformsUri.buildUpon().appendPath(nodeextended.getId()).build());
        }

        private NodeTransformsOperationCreator(SQLiteDatabase sqlitedatabase, String s, String s1)
        {
            mInsertStatement = sqlitedatabase.compileStatement("INSERT INTO cloud_node_transforms (event_id, node_id, transform) VALUES (?, ?, ?);");
            mNodeTransformsUri = com.amazon.mixtape.provider.CloudNodesContract.NodeTransforms.getContentUri(s, s1);
        }

    }


    private static final String TAG = com/amazon/mixtape/account/CloudMetadataStore.getSimpleName();
    private final String mAccountId;
    private final String mCloudNodesProviderAuthority;
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private final TransactionExecutor mDatabaseTransactionExecutor;
    private final EventsOperationCreator mEventsOperationCreator;
    private final NodeOperationCreator mNodeOperationCreator;

    CloudMetadataStore(Context context, String s, String s1, SQLiteDatabase sqlitedatabase)
    {
        mContext = context;
        mCloudNodesProviderAuthority = s;
        mAccountId = s1;
        mDatabase = sqlitedatabase;
        mNodeOperationCreator = new NodeOperationCreator(mDatabase, mCloudNodesProviderAuthority, mAccountId);
        mEventsOperationCreator = new EventsOperationCreator(mDatabase);
        mDatabaseTransactionExecutor = new TransactionExecutor(mDatabase);
    }

    static void bindValue(SQLiteStatement sqlitestatement, int i, Long long1)
    {
        if (long1 != null)
        {
            sqlitestatement.bindLong(i, long1.longValue());
            return;
        } else
        {
            sqlitestatement.bindNull(i);
            return;
        }
    }

    static void bindValue(SQLiteStatement sqlitestatement, int i, String s)
    {
        if (s != null)
        {
            sqlitestatement.bindString(i, s);
            return;
        } else
        {
            sqlitestatement.bindNull(i);
            return;
        }
    }

    private void executeSafeVacuum()
    {
        try
        {
            mDatabase.execSQL("VACUUM");
            return;
        }
        catch (SQLException sqlexception)
        {
            Log.w(TAG, "Failed to execute VACUUM on clear.");
        }
    }

    private static String getChangeType(NodeExtended nodeextended)
    {
        if ("PURGED".equals(nodeextended.getStatus()) || "TRASH".equals(nodeextended.getStatus()))
        {
            return "DELETE";
        } else
        {
            return "INSERT_OR_UPDATE";
        }
    }

    private ContentProviderClient getContentProviderClient()
    {
        return mContext.getContentResolver().acquireContentProviderClient(mCloudNodesProviderAuthority);
    }

    private void notifyUri(Uri uri)
    {
        mContext.getContentResolver().notifyChange(uri, null);
    }

    private void notifyUris(Set set)
    {
        ContentResolver contentresolver = mContext.getContentResolver();
        for (set = set.iterator(); set.hasNext(); contentresolver.notifyChange((Uri)set.next(), null)) { }
    }

    private long rawQueryForLong(String s, String as[])
        throws MetadataSyncException
    {
        s = mDatabase.rawQuery(s, as);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        long l;
        if (!s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_39;
        }
        l = s.getLong(0);
        s.close();
        return l;
        s.close();
        throw new MetadataSyncException("Failed to find a result for raw query.");
        as;
        s.close();
        throw as;
    }

    private void resetWithoutNotifications(final Set urisToNotify)
    {
        mDatabaseTransactionExecutor.execute(new Runnable() {

            final CloudMetadataStore this$0;
            final Set val$urisToNotify;

            public void run()
            {
                mDatabase.delete("checkpoints", null, null);
                urisToNotify.add(com.amazon.mixtape.provider.CloudNodesContract.Checkpoints.getContentUri(mCloudNodesProviderAuthority, mAccountId));
                mDatabase.delete("cloud_nodes", null, null);
                urisToNotify.add(com.amazon.mixtape.provider.CloudNodesContract.Nodes.getContentUri(mCloudNodesProviderAuthority, mAccountId));
                mDatabase.delete("cloud_node_parents", null, null);
                urisToNotify.add(com.amazon.mixtape.provider.CloudNodesContract.NodeParents.getContentUri(mCloudNodesProviderAuthority, mAccountId));
                urisToNotify.add(com.amazon.mixtape.provider.CloudNodesContract.MediaParents.getContentUri(mCloudNodesProviderAuthority, mAccountId));
                urisToNotify.add(com.amazon.mixtape.provider.CloudNodesContract.NodeChildren.getContentUri(mCloudNodesProviderAuthority, mAccountId));
                mDatabase.delete("document_authors", null, null);
                urisToNotify.add(com.amazon.mixtape.provider.CloudNodesContract.DocumentAuthors.getContentUri(mCloudNodesProviderAuthority, mAccountId));
                mDatabase.delete("events", null, null);
                urisToNotify.add(com.amazon.mixtape.provider.CloudNodesContract.Events.getContentUri(mCloudNodesProviderAuthority, mAccountId));
                mDatabase.delete("cloud_node_properties", null, null);
                urisToNotify.add(com.amazon.mixtape.provider.CloudNodesContract.NodeProperties.getContentUri(mCloudNodesProviderAuthority, mAccountId));
                mDatabase.delete("cloud_node_labels", null, null);
                urisToNotify.add(com.amazon.mixtape.provider.CloudNodesContract.NodeLabels.getContentUri(mCloudNodesProviderAuthority, mAccountId));
                mDatabase.delete("cloud_media_parents", null, null);
                urisToNotify.add(com.amazon.mixtape.provider.CloudNodesContract.MediaParents.getContentUri(mCloudNodesProviderAuthority, mAccountId));
                mDatabase.delete("cloud_node_transforms", null, null);
                urisToNotify.add(com.amazon.mixtape.provider.CloudNodesContract.NodeTransforms.getContentUri(mCloudNodesProviderAuthority, mAccountId));
                mDatabase.delete("cloud_node_cover_photos", null, null);
                urisToNotify.add(com.amazon.mixtape.provider.CloudNodesContract.NodeCoverPhotos.getContentUri(mCloudNodesProviderAuthority, mAccountId));
            }

            
            {
                this$0 = CloudMetadataStore.this;
                urisToNotify = set;
                super();
            }
        });
    }

    private void saveNodesWithoutNotify(final List nodes, final boolean shouldUpdateMediaParents, final Set urisToNotify)
    {
        mDatabaseTransactionExecutor.execute(new Runnable() {

            final CloudMetadataStore this$0;
            final List val$nodes;
            final boolean val$shouldUpdateMediaParents;
            final Set val$urisToNotify;

            public void run()
            {
                long l = 0x7fffffffffffffffL;
                int j = nodes.size();
                for (int i = 0; i < j;)
                {
                    NodeExtended nodeextended = (NodeExtended)nodes.get(i);
                    long l2 = mEventsOperationCreator.insert(nodeextended);
                    long l1 = l;
                    if (l2 < l)
                    {
                        l1 = l2;
                    }
                    mNodeOperationCreator.insertOrUpdate(l2, nodeextended, urisToNotify);
                    i++;
                    l = l1;
                }

                urisToNotify.add(com.amazon.mixtape.provider.CloudNodesContract.Events.getContentUri(mCloudNodesProviderAuthority, mAccountId));
                if (shouldUpdateMediaParents)
                {
                    CloudMediaParentsRollupHelper.updateCloudMediaParents(mDatabase, l);
                    urisToNotify.add(com.amazon.mixtape.provider.CloudNodesContract.MediaParents.getContentUri(mCloudNodesProviderAuthority, mAccountId));
                }
            }

            
            {
                this$0 = CloudMetadataStore.this;
                nodes = list;
                urisToNotify = set;
                shouldUpdateMediaParents = flag;
                super();
            }
        });
    }

    public void addAccountMetadataState(String s)
        throws MetadataSyncException
    {
        ContentProviderClient contentproviderclient = getContentProviderClient();
        String s1 = ISO8601.getUTCString(new Date());
        ContentValues contentvalues = new ContentValues(3);
        contentvalues.put("state", s);
        contentvalues.put("change_date", s1);
        contentvalues.put("metadata_version", Integer.valueOf(5));
        contentproviderclient.insert(com.amazon.mixtape.provider.CloudNodesContract.AccountMetadataStates.getContentUri(mCloudNodesProviderAuthority, mAccountId), contentvalues);
        contentproviderclient.release();
        return;
        s;
        throw new MetadataSyncException("Failed to update the account's metadata state.", s);
        s;
        contentproviderclient.release();
        throw s;
    }

    public void clearStore()
    {
        final HashSet urisToNotify = new HashSet();
        mDatabaseTransactionExecutor.execute(new Runnable() {

            final CloudMetadataStore this$0;
            final Set val$urisToNotify;

            public void run()
            {
                resetWithoutNotifications(urisToNotify);
                mDatabase.delete("account_metadata_states", null, null);
                urisToNotify.add(com.amazon.mixtape.provider.CloudNodesContract.AccountMetadataStates.getContentUri(mCloudNodesProviderAuthority, mAccountId));
            }

            
            {
                this$0 = CloudMetadataStore.this;
                urisToNotify = set;
                super();
            }
        });
        executeSafeVacuum();
        notifyUris(urisToNotify);
    }

    public void close()
    {
        mEventsOperationCreator.close();
        mNodeOperationCreator.close();
    }

    public long getCurrentNodesCount()
    {
        return mDatabase.compileStatement("SELECT COUNT(*) FROM cloud_nodes").simpleQueryForLong();
    }

    public long getCurrentStoreSize()
        throws MetadataSyncException
    {
        return rawQueryForLong("PRAGMA page_count", null) * rawQueryForLong("PRAGMA page_size", null);
    }

    public String getLastCheckpoint()
    {
        Cursor cursor = null;
        Cursor cursor1 = mDatabase.query("checkpoints", new String[] {
            "checkpoint_id"
        }, null, null, null, null, "_id DESC", "1");
        cursor = cursor1;
        if (!cursor1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_74;
        }
        cursor = cursor1;
        String s = cursor1.getString(cursor1.getColumnIndex("checkpoint_id"));
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return s;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return null;
        Exception exception;
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
    }

    public MetadataStore.MetadataState getMostRecentAccountMetadataState()
        throws MetadataSyncException
    {
        Cursor cursor;
        Cursor cursor1;
        ContentProviderClient contentproviderclient;
        contentproviderclient = getContentProviderClient();
        cursor1 = null;
        cursor = null;
        Cursor cursor2 = contentproviderclient.query(com.amazon.mixtape.provider.CloudNodesContract.AccountMetadataStates.getContentUri(mCloudNodesProviderAuthority, mAccountId), new String[] {
            "state", "metadata_version"
        }, null, null, "_id DESC");
        cursor = cursor2;
        cursor1 = cursor2;
        if (!cursor2.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_123;
        }
        cursor = cursor2;
        cursor1 = cursor2;
        MetadataStore.MetadataState metadatastate = new MetadataStore.MetadataState(cursor2.getString(cursor2.getColumnIndex("state")), cursor2.getInt(cursor2.getColumnIndex("metadata_version")));
        if (cursor2 != null)
        {
            cursor2.close();
        }
        contentproviderclient.release();
        return metadatastate;
        cursor = cursor2;
        cursor1 = cursor2;
        metadatastate = new MetadataStore.MetadataState(null, 0);
        if (cursor2 != null)
        {
            cursor2.close();
        }
        contentproviderclient.release();
        return metadatastate;
        RemoteException remoteexception;
        remoteexception;
        cursor1 = cursor;
        throw new MetadataSyncException("Failed to query for the account metadata states", remoteexception);
        Exception exception;
        exception;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        contentproviderclient.release();
        throw exception;
    }

    public void resetCheckpoint()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("checkpoint_id", "");
        mDatabase.insertOrThrow("checkpoints", null, contentvalues);
        notifyUri(com.amazon.mixtape.provider.CloudNodesContract.Checkpoints.getContentUri(mCloudNodesProviderAuthority, mAccountId));
    }

    public void resetStore()
    {
        HashSet hashset = new HashSet(9);
        resetWithoutNotifications(hashset);
        notifyUris(hashset);
    }

    public void saveNodes(List list)
    {
        saveNodes(list, true);
    }

    public void saveNodes(final List nodes, final String checkpoint, final String lastCheckpoint)
        throws MetadataSyncException
    {
        if (nodes.isEmpty() || checkpoint == null)
        {
            return;
        } else
        {
            final HashSet urisToNotify = new HashSet(9);
            mDatabaseTransactionExecutor.execute(new Runnable() {

                final CloudMetadataStore this$0;
                final String val$checkpoint;
                final String val$lastCheckpoint;
                final List val$nodes;
                final Set val$urisToNotify;

                public void run()
                {
                    String s = getLastCheckpoint();
                    if (lastCheckpoint != null && !lastCheckpoint.equals(s) || s != null && !s.equals(lastCheckpoint))
                    {
                        return;
                    } else
                    {
                        saveNodesWithoutNotify(nodes, true, urisToNotify);
                        ContentValues contentvalues = new ContentValues();
                        contentvalues.put("checkpoint_id", checkpoint);
                        mDatabase.insert("checkpoints", null, contentvalues);
                        urisToNotify.add(com.amazon.mixtape.provider.CloudNodesContract.Checkpoints.getContentUri(mCloudNodesProviderAuthority, mAccountId));
                        return;
                    }
                }

            
            {
                this$0 = CloudMetadataStore.this;
                lastCheckpoint = s;
                nodes = list;
                urisToNotify = set;
                checkpoint = s1;
                super();
            }
            });
            notifyUris(urisToNotify);
            return;
        }
    }

    public void saveNodes(List list, boolean flag)
    {
        if (list.isEmpty())
        {
            return;
        } else
        {
            HashSet hashset = new HashSet(9);
            saveNodesWithoutNotify(list, flag, hashset);
            notifyUris(hashset);
            return;
        }
    }









}
