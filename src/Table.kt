data class downloads(
        val id: Int,
        val guid: String,
        val current_path: String,
        val target_path: String,
        val start_time: Int,
        val received_bytes: Int,
        val total_bytes: Int,
        val state: Int,
        val danger_type: Int,
        val interrupt_reason: Int,
        val hash: String,
        val end_time: Int,
        val opened: Int,
        val last_access_time: Int,
        val transient: Int,
        val referrer: String,
        val site_url: String,
        val tab_url: String,
        val tab_referrer_url: String,
        val http_method: String,
        val by_ext_id: String,
        val by_ext_name: String,
        val etag: String,
        val last_modified: String,
        val mime_type: String,
        val original_mime_type: String
)


data class downloads_url_chains(
        val id: Int,
        val chain_index: Int,
        val url: String
)

data class downloads_slices(
        val download_id: Int,
        val offset: Int,
        val received_bytes: Int
)

data class meta(
        val key: String,
        val value: String
)

data class urls(
        val id: Int,
        val url: String,
        val title: String,
        val visit_count: Int,
        val typed_count: Int,
        val last_visit_time: Int,
        val hidden: Int
)

data class keyword_search_terms(
        val keyword_id: Int,
        val url_id: Int,
        val lower_term: String,
        val term: String
)

data class segments(
        val id: Int,
        val name: String,
        val url_id: Int
)

data class segment_usage(
        val id: Int,
        val segment_id: Int,
        val time_slot: Int,
        val visit_count: Int
)

data class visits(
        val id: Int,
        val url: Int,
        val visit_time: Int,
        val from_visit: Int,
        val transition: Int,
        val segment_id: Int,
        val visit_duration: Int
)

data class visit_source(
        val id: Int,
        val source: Int
)

data class typed_url_sync_metadata(
        val storage_key: Int,
        val value: String
)